package com.yj.lab.admin.service.test;

import com.yj.lab.common.model.rdb.entity.pg.Test;

/**
 * @author Zhang Yongjie
 */
public interface TestRedisService {

    Integer saveRedis(Test test);

    Test getRedis(String id);

}
