package com.yj.lab.admin.service.test.impl;

import com.alibaba.fastjson2.JSON;
import com.yj.lab.admin.config.redis.RedisUtil;
import com.yj.lab.admin.service.test.TestRedisService;
import com.yj.lab.common.model.rdb.entity.pg.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhang Yongjie
 */
@Slf4j
@Service
public class TestRedisServiceImpl implements TestRedisService {

    @Autowired
    private RedisUtil redisUtil;

    private static final String TEST_REDIS_KEY = "test_redis_key:";

    @Override
    public Integer saveRedis(Test test) {
        long startTime = System.currentTimeMillis();

        int result = 0;
        String key = TEST_REDIS_KEY.concat(test.getId());
        String value = JSON.toJSONString(test);
        redisUtil.setex(key, RedisUtil.ExpireTime.THIRTY_MINUTE, value, RedisUtil.RedisDbIndex.BUSINESS_DATA_DB);
        result = 1;

        long endTime = System.currentTimeMillis();
        log.info("保存 saveRedis, 内容：{},消耗时间：{}ms", test, endTime - startTime);

        return result;
    }

    @Override
    public Test getRedis(String id) {
        long startTime = System.currentTimeMillis();

        String key = TEST_REDIS_KEY.concat(id);
        String value = redisUtil.get(key, RedisUtil.RedisDbIndex.BUSINESS_DATA_DB);

        long endTime = System.currentTimeMillis();
        log.info("获取 getRedis, 内容：{},消耗时间：{}ms", value, endTime - startTime);

        return JSON.parseObject(value, Test.class);
    }

}
