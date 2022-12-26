package com.yj.lab.admin.config.os;

import com.alibaba.fastjson2.JSON;
import com.yj.lab.common.model.rdb.entity.pg.IdEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.CreateIndexResponse;
import org.opensearch.client.indices.GetIndexRequest;
import org.opensearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public static void main(String[] args) {


    }


}
















