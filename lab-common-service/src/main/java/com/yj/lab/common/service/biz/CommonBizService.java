package com.yj.lab.common.service.biz;

import com.yj.lab.common.model.vo.request.HomeRequestVo;
import com.yj.lab.common.model.vo.response.HomeResponseVo;

/**
 * @author Zhang Yongjie
 */
public interface CommonBizService {

    /**
     * 标准GET请求
     *
     * @param userId 入参
     * @return 出参
     */
    HomeResponseVo get(String userId);

    /**
     * 标准POST请求
     *
     * @param requestVo 入参
     * @return 出参
     */
    Boolean post(HomeRequestVo requestVo);

    /**
     * POST 请求，内部调用Async方法，使用Global线程池
     *
     * @return 出参
     */
    Boolean postAsyncGlobal();

    /**
     * POST 请求，内部调用Async方法，使用 指定 线程池
     *
     * @return 出参
     */
    Boolean postAsyncSome(HomeRequestVo homeRequestVo);
}
