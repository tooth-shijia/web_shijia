package com.shijia.web.common.framework.ajax;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class AjaxHandlerAdapter implements HandlerAdapter {

	private static final Logger logger=LoggerFactory.getLogger(AjaxHandlerAdapter.class);
	private Map<Ajax, Method> mapMethod = new HashMap<Ajax, Method>();
	
	public boolean supports(Object handler) {
		for (Method m : handler.getClass().getDeclaredMethods()) {
			Ajax ajax = m.getAnnotation(Ajax.class);
			if (ajax != null) {
				mapMethod.put(ajax, m);
			}
		}
		return !this.mapMethod.isEmpty();
	}

	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String path = request.getRequestURI();
		String jsonpParam = request.getParameter("callback");
		String callback = "jsonpCallback";
		if (StringUtils.isNotEmpty(jsonpParam))
			callback = jsonpParam;
		Ajax ajaxAnnotation = null;
		AjaxValue AjaxReturn = new AjaxValue();
		for (Entry<Ajax, Method> e : this.mapMethod.entrySet()) {
			String url = e.getKey().url().length > 0 ? e.getKey().url()[0] : "";
			if (path.toLowerCase().contains(url.toLowerCase())) {
				Method m = e.getValue();
				ajaxAnnotation = e.getKey();
				LocalVariableTableParameterNameDiscoverer discover = new LocalVariableTableParameterNameDiscoverer();
				String[] paramName = discover.getParameterNames(m);
				int i = 0;
				Object[] valueList = new Object[paramName.length];
				for (Class<?> instance : m.getParameterTypes()) {
					Object param = null;

					if (instance.isPrimitive() || (instance.isAssignableFrom(String.class))) {

						param = ConvertUtils.convert(
								request.getParameter(paramName[i]), instance);

					} else {

						if (!instance.isMemberClass())

							param = instance.newInstance();
						else
							param = instance.getDeclaredConstructors()[0]
									.newInstance(instance.getDeclaringClass()
											.newInstance());
						WebRequestDataBinder binder = new WebRequestDataBinder(
								param, paramName[i]);
						binder.bind(request);

					}
					valueList[i] = param;
					i++;
				}
				try {
					AjaxReturn.setValue(m.invoke(handler, valueList));
					AjaxReturn.setSuccess(true);
					AjaxReturn.setMessage("");
				} catch (Exception ex) {
					AjaxReturn.setMessage(ex.getMessage());
					AjaxReturn.setSuccess(false);
					logger.error(
							"Ajax error" + ex.getMessage(), ex);
				}

			}
		}
		JsonView view = new JsonView();
		ModelAndView mv = new ModelAndView(view);
		mv.addObject(view.AjaxReturn, AjaxReturn);
		mv.addObject(view.AjaxAnnotation, ajaxAnnotation);
		mv.addObject(view.AjaxCallback, callback);
		return mv;
	}

	public long getLastModified(HttpServletRequest request, Object handler) {
		return 0;
	}


}
