package com.yj.lab.admin.config.os;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.yj.lab.common.model.rdb.entity.pg.IdEntity;
import com.yj.lab.common.model.vo.request.common.OsPageRequestVo;
import com.yj.lab.common.model.vo.response.common.PageResponseVo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.CreateIndexResponse;
import org.opensearch.client.indices.GetIndexRequest;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhang Yongjie
 */
@Slf4j
@Component
public class OpenSearchUtil {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public static class Index {
        public static final String USER_INDEX = "user";
        public static final String JD_PRODUCT_INDEX = "jd_product";
    }

    @SneakyThrows
    public boolean createIndex(String index) {

        boolean result = false;
        GetIndexRequest getIndexRequest = new GetIndexRequest(index);
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        if (exists) {
            log.info("索引{}已存在", index);
            result = true;
        } else {
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            log.info(JSON.toJSONString(createIndexResponse));
            if (createIndexResponse.isAcknowledged()) {
                result = true;
            }
        }
        return result;
    }

    @SneakyThrows
    public <T extends IdEntity> boolean bulkAddDoc(String index, List<T> entityList) {

        boolean result = false;
        BulkRequest bulkRequest = new BulkRequest();
        for (T entity : entityList) {
            bulkRequest.add(new IndexRequest(index).id(entity.getId()).source(JSON.toJSONString(entity), XContentType.JSON));
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        log.info(JSON.toJSONString(bulkResponse));
        if (!bulkResponse.hasFailures()) {
            result = true;
        }
        return result;
    }

    @SneakyThrows
    public <T> PageResponseVo<T> searchPage(OsPageRequestVo<T> osPageRequestVo, QueryBuilder queryBuilder) {
        // 根据传入的 OsPageRequestVo 对象，构建 QueryBuilder
        // QueryBuilder queryBuilder = QueryBuilders.termQuery("name", osPageRequestVo.getEntity().getName());

        PageResponseVo<T> result = new PageResponseVo<>();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.timeout(new TimeValue(2, TimeUnit.SECONDS));
        searchSourceBuilder.query(queryBuilder);
        int size = osPageRequestVo.getPageSize().intValue();
        int from = osPageRequestVo.getPageNum().intValue() * size;
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);

        SearchRequest searchRequest = new SearchRequest(osPageRequestVo.getIndex());
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

//        List<T> entitys = new ArrayList<>();
//        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
//            T entity = JSON.parseObject(searchHit.getSourceAsString(), new TypeReference<T>(){});
//            entitys.add(entity);
//            log.info(JSON.toJSONString(entity));
//        }

        List<T> entitys = Arrays.stream(searchResponse.getHits().getHits()).parallel()
                .map(x -> JSON.<T>parseObject(x.getSourceAsString(), new TypeReference<T>() {
                }))
                .toList();

        result.setPageSize(osPageRequestVo.getPageSize());
        result.setPageNum(osPageRequestVo.getPageNum());
        result.setList(entitys);
        result.setTotal(searchResponse.getHits().getTotalHits().value);
        Long pages = result.getTotal() / result.getPageSize();
        result.setPages(pages);

        return result;
    }


    public static void main(String[] args) {
        int i = 33 / 10;
        Long i2 = 33L / 10L;
        System.out.println(i);
        System.out.println(i2);

    }


}
















