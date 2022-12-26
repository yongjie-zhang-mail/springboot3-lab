package com.yj.lab.admin.controller;

import com.yj.lab.admin.service.test.TestOsService;
import com.yj.lab.common.model.rdb.entity.pg.Product;
import com.yj.lab.common.model.rdb.entity.pg.User;
import com.yj.lab.common.model.vo.request.common.OsPageRequestVo;
import com.yj.lab.common.model.vo.request.common.PageRequestVo;
import com.yj.lab.common.model.vo.response.common.PageResponseVo;
import com.yj.lab.common.model.vo.response.common.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhang Yongjie
 */
@Slf4j
@RestController
@RequestMapping("v1/testos")
@Api(tags = "DAM-Test-v1")
//@CrossOrigin
public class TestOsController {

    @Autowired
    private TestOsService testOsService;

    @GetMapping("getOs")
    @ApiOperation(value = "获取 Open Search")
    public ResultEntity<String> getOs() {
        String result = testOsService.getOs();
        return ResultEntity.getSuccessResult(result);
    }

    @PostMapping("createIndex")
    @ApiOperation("创建 os 索引 user")
    public ResultEntity<String> createIndex() {
        testOsService.createIndex();
        return ResultEntity.getSuccessResult();
    }

    @PostMapping("deleteIndex")
    @ApiOperation("删除 os 索引 user")
    public ResultEntity<String> deleteIndex() {
        testOsService.deleteIndex();
        return ResultEntity.getSuccessResult();
    }

    @PostMapping("addDoc")
    @ApiOperation("往 user 索引中 添加 文档")
    public ResultEntity<String> addDoc() {
        testOsService.addDoc();
        return ResultEntity.getSuccessResult();
    }

    @GetMapping("getDoc")
    @ApiOperation("从 user 索引中 查询 文档 by id")
    public ResultEntity<User> getDoc() {
        User user = testOsService.getDoc();
        return ResultEntity.getSuccessResult(user);
    }

    @PostMapping("updateDoc")
    @ApiOperation("往 user 索引中 更新 文档")
    public ResultEntity<String> updateDoc() {
        testOsService.updateDoc();
        return ResultEntity.getSuccessResult();
    }

    @PostMapping("deleteDoc")
    @ApiOperation("往 user 索引中 删除 文档")
    public ResultEntity<String> deleteDoc() {
        testOsService.deleteDoc();
        return ResultEntity.getSuccessResult();
    }

    @PostMapping("bulkAddDoc")
    @ApiOperation("往 user 索引中 批量添加 文档")
    public ResultEntity<String> bulkAddDoc() {
        testOsService.bulkAddDoc();
        return ResultEntity.getSuccessResult();
    }

    @PostMapping("searchDoc")
    @ApiOperation("从 user 索引中 查询文档 - term")
    public ResultEntity<List<User>> searchDoc() {
        List<User> users = testOsService.searchDoc();
        return ResultEntity.getSuccessResult(users);
    }

    @PostMapping("createOsData")
    @ApiOperation("创建 jd_product 索引，并存入 keyword 查询到的数据")
    public ResultEntity<Boolean> createOsData(@RequestParam(defaultValue = "pytorch") String keyword) {
        boolean result = testOsService.createOsData(keyword);
        return ResultEntity.getSuccessResult(result);
    }

    @PostMapping("searchPage")
    @ApiOperation("searchPage")
    public ResultEntity<PageResponseVo<Product>> searchPage(@RequestBody PageRequestVo<Product> pageRequestVo) {
        PageResponseVo<Product> result = testOsService.searchPage(pageRequestVo);
        return ResultEntity.getSuccessResult(result);
    }

    @PostMapping("searchPage2")
    @ApiOperation("searchPage2")
    public ResultEntity<PageResponseVo<Product>> searchPage2(@RequestBody OsPageRequestVo<Product> osPageRequestVo) {
        log.info("测试版本是否回退正常");
        PageResponseVo<Product> result = testOsService.searchPage(osPageRequestVo);
        return ResultEntity.getSuccessResult(result);
    }


}








































