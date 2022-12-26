package com.yj.lab.common.service.aspect;

import com.yj.lab.common.model.anno.DemoAnno;
import com.yj.lab.common.service.common.BizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * @author Zhang Yongjie
 */
@Slf4j
@Aspect
@Component
public class DemoAspect {

    @Autowired
    private BizService bizService;

    @Before("@annotation(demoAnno)")
    public void demoCheck(JoinPoint jp, DemoAnno demoAnno) {

        ServletRequestAttributes sras = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sras != null;

        HttpServletRequest request = sras.getRequest();
        HttpServletResponse response = sras.getResponse();

        bizService.bizLogic();

    }
}