package com.yj.lab.admin.controller;

import com.yj.lab.admin.service.biz.HomeService;
import com.yj.lab.admin.service.test.TestPgService;
import com.yj.lab.admin.service.test.TestRedisService;
import com.yj.lab.common.model.anno.DemoAnno;
import com.yj.lab.common.model.rdb.entity.pg.Test;
import com.yj.lab.common.model.vo.request.HomeRequestVo;
import com.yj.lab.common.model.vo.response.HomeResponseVo;
import com.yj.lab.common.model.vo.response.common.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author Zhang Yongjie
 */
@Slf4j
@RestController
@RequestMapping("v1/home")
@Api(tags = "DAM-Home-v1")
public class HomeController {

    @Autowired
    private TestPgService testPgService;
    @Autowired
    private TestRedisService testRedisService;

    @PostMapping("saveRedis")
    @ApiOperation("保存 Redis")
    public ResultEntity<String> saveRedis() {
        Test test = new Test();
        test.setId("uuid123456");
        test.setCount(10);
        test.setCreateTime(new Date());

        Integer result = testRedisService.saveRedis(test);
        return ResultEntity.getSuccessResult(result.toString());
    }

    @GetMapping("getRedis")
    @ApiOperation(value = "获取 Redis")
    public ResultEntity<Test> getRedis() {
        Test result = testRedisService.getRedis("uuid123456");
        return ResultEntity.getSuccessResult(result);
    }


    @PostMapping("postPg")
    @ApiOperation("保存 PG")
    public ResultEntity<String> postPg() {
        Integer result = testPgService.insertPg();
        return ResultEntity.getSuccessResult(result.toString());
    }

    @GetMapping("getPg")
    @ApiOperation(value = "获取 PG")
    public ResultEntity<Test> getPg() {
        Test result = testPgService.getPg();
        return ResultEntity.getSuccessResult(result);
    }


    @GetMapping("get6")
    @ApiOperation("get6")
    public String get6(@RequestHeader(required = false, defaultValue = "1") Integer tenantId,
                       @RequestParam(defaultValue = "1234") String userId) {
        log.info("get 6 log info test");
        return "get6 response";
    }

    @Autowired
    private HomeService homeService;

    @GetMapping("get1")
    @ApiOperation("get1")
    public ResultEntity<HomeResponseVo> get(@RequestHeader(required = false, defaultValue = "1") Integer tenantId,
                                            @RequestParam(defaultValue = "1234") String userId) {
        HomeResponseVo responseVo = homeService.get(userId);
        return ResultEntity.getSuccessResult(responseVo);
    }

    @PostMapping("post1")
    @ApiOperation("post1")
    public ResultEntity<String> post(@RequestHeader(required = false, defaultValue = "1") Integer tenantId,
                                     @RequestBody HomeRequestVo homeRequestVo) {
        Boolean result = homeService.post(homeRequestVo);
        return ResultEntity.getSuccessResult(result.toString());
    }

    @DemoAnno(id = 200)
    @PostMapping("post2")
    @ApiOperation("post2")
    public ResultEntity<String> postAsyncGlobal(@RequestHeader(required = false, defaultValue = "1") Integer tenantId) {
        Boolean result = homeService.postAsyncGlobal();
        return ResultEntity.getSuccessResult(result.toString());
    }

    @PostMapping("post3")
    @ApiOperation("post3")
    public ResultEntity<String> postAsyncSome(@RequestHeader(required = false, defaultValue = "1") Integer tenantId,
                                              @RequestBody HomeRequestVo homeRequestVo) {
        Boolean result = homeService.postAsyncSome(homeRequestVo);
        return ResultEntity.getSuccessResult(result.toString());
    }


}

























