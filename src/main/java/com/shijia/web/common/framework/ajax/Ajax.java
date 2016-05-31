package com.shijia.web.common.framework.ajax;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface Ajax { 

	String[] url() default {};
	String[] resource() default {};
	boolean  inherited() default false;
	String type() default "";
	
}
