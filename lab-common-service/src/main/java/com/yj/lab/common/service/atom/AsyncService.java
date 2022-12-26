package com.yj.lab.common.service.atom;

import com.yj.lab.common.model.vo.request.HomeRequestVo;

/**
 * @author Zhang Yongjie
 */
public interface AsyncService {

    /**
     * 异步方法，使用 Global 线程池 mainTp
     */
    void asyncGlobal();

    /**
     * 异步方法，使用 指定线程池 secondTp
     *
     * @param homeRequestVo 入参
     * @return 出参
     */
    String doAsync(HomeRequestVo homeRequestVo);

}
