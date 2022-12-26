package com.yj.lab.common.service.biz.impl;

import com.yj.lab.common.model.vo.request.HomeRequestVo;
import com.yj.lab.common.model.vo.response.HomeResponseVo;
import com.yj.lab.common.service.atom.AsyncService;
import com.yj.lab.common.service.biz.CommonBizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhang Yongjie
 */
@Slf4j
@Service
public class CommonBizImpl implements CommonBizService {

    @Autowired
    private AsyncService asyncService;

    @Override
    public HomeResponseVo get(String userId) {
        HomeResponseVo responseVo = new HomeResponseVo();
        responseVo.setName("demo name 22222");
        responseVo.setPhone("11111111111");
        responseVo.setGender(1);
        return responseVo;
    }

    @Override
    public Boolean post(HomeRequestVo requestVo) {
        boolean result = true;
        try {
            Thread.sleep(1000);
            log.info("do something.");
        } catch (InterruptedException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Boolean postAsyncGlobal() {
        asyncService.asyncGlobal();
        Boolean result = true;
        return result;
    }

    @Override
    public Boolean postAsyncSome(HomeRequestVo homeRequestVo) {
        String s = asyncService.doAsync(homeRequestVo);
        Boolean result = true;
        return result;
    }

}




























