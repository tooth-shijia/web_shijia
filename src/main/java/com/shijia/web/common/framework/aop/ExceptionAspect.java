package com.shijia.web.common.framework.aop;

import com.shijia.web.common.framework.annotation.IgnoreException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * 异常记录日志，最后继续抛出
 *
 * @author YanxiSir
 * @since 16/11/30
 */
@Aspect
@Order(1)
@Component
public class ExceptionAspect extends BaseAspect {

    private static Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Around("allLayer() ")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {

        Annotation ignoreAutoResp = joinPoint.getSignature().getDeclaringType().getAnnotation(IgnoreException.class);
        if (ignoreAutoResp != null) {
            return joinPoint.proceed();
        }
        if (joinPoint.getSignature() instanceof MethodSignature) {

            MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            ignoreAutoResp = ms.getMethod().getAnnotation(IgnoreException.class);
            if (ignoreAutoResp != null) {
                return joinPoint.proceed();
            }
        }
        String methodName = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
        try {
            return joinPoint.proceed();
        } catch (Exception ex) {
            logger.error(methodName + " : ", ex);
            throw ex;
        }
    }
}
