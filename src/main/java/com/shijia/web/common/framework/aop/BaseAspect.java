package com.shijia.web.common.framework.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseAspect {

    @Pointcut("execution(public * com.shijia.web.controller..*Controller.*(..))")
    public void controllerLayer() {
        // Controller layer
    }

    @Pointcut("execution(* com.shijia.web.service..*.*(..))")
    public void serviceLayer() {
        // Serivice layer
    }


    @Pointcut("execution(* com.shijia.web.repository..*.*(..))")
    public void repositoryLayer() {
        // Repository layer
    }

    @Pointcut("execution(public * com.shijia.web.controller..*Controller.*(..)) " +
            "or execution(* com.shijia.web.service..*.*(..))+" +
            "or execution(* com.shijia.web.repository..*.*(..))")
    public void allLayer() {

    }
}
