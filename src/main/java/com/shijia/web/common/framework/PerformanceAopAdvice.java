package com.shijia.web.common.framework;

import com.shijia.web.common.utils.LogHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;


public class PerformanceAopAdvice {

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
            if (e != null) {
                LogHelper.error(methodName, e);
            }
            throw e;
        } finally {
            sw.stop();
            LogHelper.info(methodName + ":" + sw.getTotalTimeMillis());
        }
        // 返回业务方法返回值
        return returnValue;
    }

}
