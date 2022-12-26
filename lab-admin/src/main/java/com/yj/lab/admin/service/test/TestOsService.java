package com.yj.lab.admin.service.test;

import com.yj.lab.common.model.rdb.entity.pg.Product;
import com.yj.lab.common.model.rdb.entity.pg.User;
import com.yj.lab.common.model.vo.request.common.OsPageRequestVo;
import com.yj.lab.common.model.vo.request.common.PageRequestVo;
import com.yj.lab.common.model.vo.response.common.PageResponseVo;
import lombok.SneakyThrows;

import java.util.List;

/**
 * @author Zhang Yongjie
 */
public interface TestOsService {

    String getOs();

    void createIndex();

    void deleteIndex();

    void addDoc();

    User getDoc();

    void updateDoc();

    void deleteDoc();

    void bulkAddDoc();

    List<User> searchDoc();

    boolean createOsData(String keyword);

    PageResponseVo<Product> searchPage(PageRequestVo<Product> pageRequestVo);

    @SneakyThrows
    PageResponseVo<Product> searchPage(OsPageRequestVo<Product> osPageRequestVo);
}
