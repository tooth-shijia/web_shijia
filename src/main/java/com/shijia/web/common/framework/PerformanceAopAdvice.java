package com.shijia.web.common.framework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;


public class PerformanceAopAdvice {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAopAdvice.class);

    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        // 启动一个 stop watch
        StopWatch sw = new StopWatch();
        Object[] args = pjp.getArgs();
        // 运行计时器
        String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();
        sw.start(pjp.getSignature().getName());
        // 执行业务方法
        Object returnValue = null;
        try {
            if (args != null) {
                returnValue = pjp.proceed(args);
            } else {
                returnValue = pjp.proceed();
            }
        } catch (Throwable e) {
            logger.error(methodName, e);
            throw e;
        } finally {
            sw.stop();
            logger.info(methodName + ":" + sw.getTotalTimeMillis());
        }
        // 返回业务方法返回值
        return returnValue;
    }

}
