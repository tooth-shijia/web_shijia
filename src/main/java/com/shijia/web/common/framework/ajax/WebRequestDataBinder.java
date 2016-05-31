package com.shijia.web.common.framework.ajax;


import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebRequestDataBinder extends ServletRequestDataBinder {

	private String prefix;

	public WebRequestDataBinder(Object target, String prefix) {
		super(target);
		this.prefix = prefix;
	}

 
	@SuppressWarnings("deprecation")
	@Override
	public void bind(ServletRequest request) {
		// this is the magic. Seems like if I did a getObjectName() instead of
		// passing prefix it would be better, but since I don't know what the
		// intent of objectName is I didn't.
	   this.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	   this.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class,true));
	   this.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class,true));
	  
		MutablePropertyValues mpvs = new ServletRequestParameterPropertyValues(
				request, prefix, ".");
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			bindMultipartFiles(multipartRequest.getFileMap(), mpvs);
		
		}
		doBind(mpvs);
	}
}
