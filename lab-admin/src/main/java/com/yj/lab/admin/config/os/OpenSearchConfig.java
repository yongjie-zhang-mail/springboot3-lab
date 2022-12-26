package com.yj.lab.admin.config.os;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Yongjie
 */
@Slf4j
@Configuration
public class OpenSearchConfig {

    /**
     * 协议
     */
    @Value("${opensearch.schema:http}")
    private String schema;
    /**
     * 集群地址，如果有多个用“,”隔开
     */
    @Value("${opensearch.address}")
    private String address;
    /**
     * 用户名
     */
    @Value("${opensearch.username}")
    private String username;
    /**
     * 密码
     */
    @Value("${opensearch.password}")
    private String password;
    /**
     * 连接超时时间
     */
    @Value("${opensearch.connectTimeout:1000}")
    private int connectTimeout;
    /**
     * Socket 连接超时时间
     */
    @Value("${opensearch.socketTimeout:10000}")
    private int socketTimeout;
    /**
     * 获取连接的超时时间
     */
    @Value("${opensearch.connectionRequestTimeout:500}")
    private int connectionRequestTimeout;
    /**
     * 最大连接数
     */
    @Value("${opensearch.maxConnectNum:500}")
    private int maxConnectNum;
    /**
     * 最大路由连接数
     */
    @Value("${opensearch.maxConnectPerRoute:100}")
    private int maxConnectPerRoute;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        // 拆分地址
        List<HttpHost> hostLists = new ArrayList<>();
        String[] hostList = address.split(",");
        for (String addr : hostList) {
            String host = addr.split(":")[0];
            String port = addr.split(":")[1];
            hostLists.add(new HttpHost(host, Integer.parseInt(port), schema));
        }
        // 转换成 HttpHost 数组
        HttpHost[] httpHost = hostLists.toArray(new HttpHost[]{});
        // 构建连接对象
        RestClientBuilder builder = RestClient.builder(httpHost);
        // 异步连接延时配置
        builder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(connectTimeout);
            requestConfigBuilder.setSocketTimeout(socketTimeout);
            requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeout);
            return requestConfigBuilder;
        });
        // 异步连接数配置
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            httpClientBuilder.setMaxConnTotal(maxConnectNum);
            httpClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
            httpClientBuilder.disableAuthCaching();
            // 配置连接用户名、密码
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            return httpClientBuilder;
        });
        return new RestHighLevelClient(builder);
    }

}
