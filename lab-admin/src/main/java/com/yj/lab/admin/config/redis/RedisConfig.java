package com.yj.lab.admin.config.redis;

import com.alibaba.fastjson2.JSON;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;


/**
 * @author Zhang Yongjie
 */
@Data
@Slf4j
@Configuration
public class RedisConfig {

    // 连接信息
//    @Value("${spring.data.redis.sentinel.master}")
//    private String sentinelMaster;
//    @Value("${spring.data.redis.sentinel.nodes}")
//    private String sentinelNodes;
    @Value("${cache.redis.host}")
    private String host;
    @Value("${cache.redis.port}")
    private int port;
    @Value("${cache.redis.password}")
    private String password;
    @Value("${cache.redis.ssl}")
    private boolean ssl;
    // 连接池配置
    @Value("${cache.redis.jedis.pool.max-total}")
    private int maxTotal;
    @Value("${cache.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${cache.redis.jedis.pool.min-idle}")
    private int minIdle;
    @Value("${cache.redis.jedis.pool.max-wait}")
    private int maxWait;
    @Value("${cache.redis.jedis.pool.timeout}")
    private int timeout;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数；例如每个请求平均耗时50ms，那么每个连接的QPS=1000ms/50ms=20qps；max-total=10000qps/20qps=500最大连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大可空闲的连接数；实际的最大连接数；
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 最小可空闲的连接数；实际的最小连接数；
        jedisPoolConfig.setMinIdle(minIdle);
        // 最大等待时间
        jedisPoolConfig.setMaxWait(Duration.ofMillis(maxWait));
        jedisPoolConfig.setJmxEnabled(false);
        return jedisPoolConfig;
    }

//    @Bean
//    public JedisSentinelPool sentinelConfiguration(JedisPoolConfig jedisPoolConfig) {
//        Set<String> sentinels = Sets.newHashSet(StringUtils.split(sentinelNodes, ","));
//        log.info("jedisNodeSet -->" + sentinels);
//        // 配置jedis的哨兵sentinel    Protocol.DEFAULT_TIMEOUT
//        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(sentinelMaster, sentinels,
//                jedisPoolConfig, timeout, password);
//        return jedisSentinelPool;
//    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, ssl);
        return jedisPool;
    }


    @SneakyThrows
    public static void main(String[] args) {

        System.out.println(1111);

        String host = "master.aem-test-redis.zjzejd.use1.cache.amazonaws.com";
        int port = 6379;
        int timeout = 10000;
        String password = "8nZ8GWndcTWaXn5-";
        boolean ssl = true;
        // 连接池配置
        int maxTotal = 500;
        int maxIdle = 400;
        int minIdle = 10;
        int maxWait = 20000;

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数；例如每个请求平均耗时50ms，那么每个连接的QPS=1000ms/50ms=20qps；max-total=10000qps/20qps=500最大连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大可空闲的连接数；实际的最大连接数；
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 最小可空闲的连接数；实际的最小连接数；
        jedisPoolConfig.setMinIdle(minIdle);
        // 最大等待时间
        jedisPoolConfig.setMaxWait(Duration.ofMillis(maxWait));
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, ssl);

        Jedis jedis = jedisPool.getResource();
        jedis.select(0);

        String CHARSET = "UTF-8";
        String TEST_REDIS_KEY = "test_redis_key:";
        String key = TEST_REDIS_KEY.concat("test.id");
        String value = JSON.toJSONString("valuestring");

        jedis.setex(key.getBytes(CHARSET), 300, value.getBytes(CHARSET));

        String returnValue = jedis.get(key);

        System.out.println(2222);

    }

}













