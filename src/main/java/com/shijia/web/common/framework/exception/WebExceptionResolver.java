package com.shijia.web.common.framework.exception;

import com.shijia.web.common.utils.LogHelper;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class WebExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);

		LogHelper.error("MVC Error " + ex.getMessage(), ex);
		ModelAndView mv = new ModelAndView("common/error");
		mv.addObject("exception", sw.toString().replaceAll("\n", "<br/>"));
		return mv;
	}

}
