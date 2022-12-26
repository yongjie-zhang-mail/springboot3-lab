package com.yj.lab.admin.service.test.impl;

import com.alibaba.fastjson2.JSON;
import com.yj.lab.admin.config.os.OpenSearchUtil;
import com.yj.lab.admin.service.test.TestOsService;
import com.yj.lab.admin.util.HtmlParserUtil;
import com.yj.lab.common.model.rdb.entity.pg.Product;
import com.yj.lab.common.model.rdb.entity.pg.User;
import com.yj.lab.common.model.vo.request.common.OsPageRequestVo;
import com.yj.lab.common.model.vo.request.common.PageRequestVo;
import com.yj.lab.common.model.vo.response.common.PageResponseVo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.delete.DeleteRequest;
import org.opensearch.action.delete.DeleteResponse;
import org.opensearch.action.get.GetRequest;
import org.opensearch.action.get.GetResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.action.support.master.AcknowledgedResponse;
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.action.update.UpdateResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.CreateIndexResponse;
import org.opensearch.client.indices.GetIndexRequest;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.SearchHit;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhang Yongjie
 */
@Slf4j
@Service
public class TestOsServiceImpl implements TestOsService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    private static final String OS_USER_INDEX = "user";


    private static void mainTest2() {
        List<User> users = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        c1.set(2000, Calendar.JANUARY, 1);
        for (int i = 0; i < 10; i++) {
            c1.add(Calendar.DAY_OF_YEAR, 1);
            int j = i + 1;
            User user = new User("100000000" + j, "user name " + j, j % 2 == 0 ? "1" : "2", c1.getTime(),
                    "1331111111" + j, "user" + j + "@qq.com");
            users.add(user);
        }
    }

    private static void mainTest1() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2000, Calendar.DECEMBER, 22);
        Date b1 = c1.getTime();

        c1.add(Calendar.DAY_OF_YEAR, 2);
        Date b2 = c1.getTime();

        User user1 = new User("1000000001", "user name 1", "1", b1, "13311111111", "user1@qq.com");
        User user2 = new User("1000000002", "user name 2", "2", b2, "13311111112", "user2@qq.com");
    }

    @Override
    public String getOs() {
        long startTime = System.currentTimeMillis();

        GetRequest request = new GetRequest("test", "1");
        GetResponse response;
        try {
            response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("Open Search 获取doc Error:{}", e.getMessage());
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        log.info("Open Search 获取doc Response: {},消耗时间：{}ms", response, endTime - startTime);
        return response.toString();
    }

    @SneakyThrows
    @Override
    public void createIndex() {

        GetIndexRequest getIndexRequest = new GetIndexRequest(OS_USER_INDEX);
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        if (exists) {
            log.info("索引{}已存在", OS_USER_INDEX);
        } else {
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(OS_USER_INDEX);
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            log.info(JSON.toJSONString(createIndexResponse));
        }

    }

    @Override
    @SneakyThrows
    public void deleteIndex() {

        GetIndexRequest getIndexRequest = new GetIndexRequest(OS_USER_INDEX);
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        if (exists) {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(OS_USER_INDEX);
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            log.info(JSON.toJSONString(delete));
        } else {
            log.info("索引{}不存在", OS_USER_INDEX);
        }

    }

    @SneakyThrows
    @Override
    public void addDoc() {

        Calendar c1 = Calendar.getInstance();
        c1.set(2000, Calendar.DECEMBER, 22);
        Date b1 = c1.getTime();

        c1.add(Calendar.DAY_OF_YEAR, 2);
        Date b2 = c1.getTime();

        User user1 = new User("1000000001", "user name 1", "1", b1, "13311111111", "user1@qq.com");
        User user2 = new User("1000000002", "user name 2", "2", b2, "13311111112", "user2@qq.com");

        IndexRequest indexRequest = new IndexRequest(OS_USER_INDEX);
        indexRequest.timeout(new TimeValue(1, TimeUnit.SECONDS));
        indexRequest.id(user1.getUid());
        indexRequest.source(JSON.toJSONString(user1), XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        log.info(JSON.toJSONString(indexResponse));

    }

    @SneakyThrows
    @Override
    public User getDoc() {

        GetRequest getRequest = new GetRequest(OS_USER_INDEX, "1000000001");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        log.info(JSON.toJSONString(getResponse));
        log.info(getResponse.getSourceAsString());
        User user = JSON.parseObject(getResponse.getSourceAsString(), User.class);
        return user;

    }

    @SneakyThrows
    @Override
    public void updateDoc() {
        // 局部更新
        UpdateRequest updateRequest = new UpdateRequest(OS_USER_INDEX, "1000000001");
        User user1 = new User();
        user1.setUid("1000000001");
        user1.setEmail("user1-1@qq.com");
        updateRequest.doc(JSON.toJSONString(user1), XContentType.JSON);
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        log.info(JSON.toJSONString(updateResponse));

    }

    @SneakyThrows
    @Override
    public void deleteDoc() {

        GetRequest getRequest = new GetRequest(OS_USER_INDEX, "1000000001");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        if (exists) {
            DeleteRequest deleteRequest = new DeleteRequest(OS_USER_INDEX, "1000000001");
            DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
            log.info(JSON.toJSONString(deleteResponse));
        } else {
            log.info("文档不存在 id:{}", "1000000001");
        }

    }

    @SneakyThrows
    @Override
    public void bulkAddDoc() {

        BulkRequest bulkRequest = new BulkRequest();

        List<User> users = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        c1.set(2000, Calendar.JANUARY, 1);
        for (int i = 0; i < 10; i++) {
            c1.add(Calendar.DAY_OF_YEAR, 1);
            int j = i + 1;
            User user = new User("100000000" + j, "user name " + j, j % 2 == 0 ? "1" : "2", c1.getTime(),
                    "1331111111" + j, "user" + j + "@qq.com");
            users.add(user);
        }

        for (User user : users) {
            bulkRequest.add(new IndexRequest(OS_USER_INDEX).id(user.getUid()).source(JSON.toJSONString(user), XContentType.JSON));
        }

        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        log.info(JSON.toJSONString(bulkResponse));

    }

    @SneakyThrows
    @Override
    public List<User> searchDoc() {

        QueryBuilder queryBuilder = QueryBuilders.termQuery("gender.keyword", "1");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.timeout(new TimeValue(5, TimeUnit.SECONDS));
        searchSourceBuilder.query(queryBuilder);

        SearchRequest searchRequest = new SearchRequest(OS_USER_INDEX);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        log.info(JSON.toJSONString(searchResponse));

        List<User> users = new ArrayList<>();
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            log.info(searchHit.getSourceAsMap().toString());
            User user = JSON.parseObject(searchHit.getSourceAsString(), User.class);
            users.add(user);
        }

        return users;

    }

    @Autowired
    private OpenSearchUtil openSearchUtil;

    @Override
    public boolean createOsData(String keyword) {
        boolean result = false;
//        OpenSearchUtil openSearchUtil = new OpenSearchUtil();
        boolean createIndexResult = openSearchUtil.createIndex(OpenSearchUtil.Index.JD_PRODUCT_INDEX);
        if (createIndexResult) {
            List<Product> products = HtmlParserUtil.parseJdProductList(keyword);
            result = openSearchUtil.bulkAddDoc(OpenSearchUtil.Index.JD_PRODUCT_INDEX, products);
        }
        return result;
    }

    @SneakyThrows
    @Override
    public PageResponseVo<Product> searchPage(PageRequestVo<Product> pageRequestVo) {
        PageResponseVo<Product> result = new PageResponseVo<>();

        QueryBuilder queryBuilder = QueryBuilders.termQuery("name", pageRequestVo.getEntity().getName());

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.timeout(new TimeValue(2, TimeUnit.SECONDS));
        searchSourceBuilder.query(queryBuilder);
        int size = pageRequestVo.getPageSize().intValue();
        int from = pageRequestVo.getPageNum().intValue() * size;
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);

        SearchRequest searchRequest = new SearchRequest(OpenSearchUtil.Index.JD_PRODUCT_INDEX);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        log.info(JSON.toJSONString(searchResponse));

        List<Product> products = new ArrayList<>();
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
//            log.info(searchHit.getSourceAsMap().toString());
            Product product = JSON.parseObject(searchHit.getSourceAsString(), Product.class);
            products.add(product);
            log.info(JSON.toJSONString(product));
        }

        result.setTotal(searchResponse.getHits().getTotalHits().value);
        result.setList(products);

        return result;
    }

    /**
     * 示例：使用封装的工具类查询 Open Search
     * 关键点：构造 QueryBuilder
     *
     * @param osPageRequestVo 分页查询入参，含分页信息，index，查询关键字等
     * @return PageResponseVo<T> 返回对应泛型实体类
     */
    @SneakyThrows
    @Override
    public PageResponseVo<Product> searchPage(OsPageRequestVo<Product> osPageRequestVo) {
        // 根据传入的 OsPageRequestVo 对象，构建 QueryBuilder
        QueryBuilder queryBuilder = QueryBuilders.termQuery("name", osPageRequestVo.getEntity().getName());

        PageResponseVo<Product> result = openSearchUtil.searchPage(osPageRequestVo, queryBuilder);

        return result;
    }


    public static void main(String[] args) {
//        mainTest1();
//        mainTest2();
        mainTest3();


    }

    private static void mainTest3() {
        PageRequestVo<Product> pageRequestVo = new PageRequestVo<>();
        Product product = new Product();
        product.setName("pytorch");
        pageRequestVo.setEntity(product);
        pageRequestVo.setPageNum(1L);
        pageRequestVo.setPageSize(10L);
        log.info(JSON.toJSONString(pageRequestVo));
    }


}





































