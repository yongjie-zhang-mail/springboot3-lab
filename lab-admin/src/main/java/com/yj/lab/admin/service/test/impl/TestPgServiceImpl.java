package com.yj.lab.admin.service.test.impl;

import com.yj.lab.admin.service.test.TestPgService;
import com.yj.lab.common.model.rdb.entity.pg.Test;
import com.yj.lab.common.model.rdb.mapper.pg.TestMapper;
import com.yj.lab.common.service.util.DateUtils;
import com.yj.lab.common.service.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Zhang Yongjie
 */
@Slf4j
@Service
public class TestPgServiceImpl implements TestPgService {

    @Autowired
    private TestMapper testMapper;

//    @Autowired
//    private RedisUtil redisUtil;


    @Override
    public Integer insertPg() {
        long startTime = System.currentTimeMillis();
        Test test = new Test();
        test.setId(UUIDUtil.getUUID());
        test.setCount(1);
        test.setCreateTime(DateUtils.nowDate());
        Integer result = testMapper.insert(test);
        long endTime = System.currentTimeMillis();
        log.info("添加postgreSql,内容：{},消耗时间：{}ms", test, endTime - startTime);
        return result;
    }

    @Override
    public Test getPg() {
        long startTime = System.currentTimeMillis();
        Test test = testMapper.selectById("52c5b39324b242bfbea3c031779bd572");
        long endTime = System.currentTimeMillis();
        log.info("获取postgreSql,内容：{},消耗时间：{}ms", test, endTime - startTime);
        return test;
    }

//    @Override
//    public void saveRedis() {
//        long startTime = System.currentTimeMillis();
//        redisUtil.set("test", "testContent");
//        long endTime = System.currentTimeMillis();
//        log.info("添加Redis,消耗时间：{}ms", endTime - startTime);
//    }
//
//    @Override
//    public String getRedis(String name) {
//        long startTime = System.currentTimeMillis();
//        String result = redisUtil.get("test");
//        long endTime = System.currentTimeMillis();
//        log.info("获取Redis,内容：{},消耗时间：{}ms", result, endTime - startTime);
//        return result;
//    }

}
