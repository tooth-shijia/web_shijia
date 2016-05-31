package com.shijia.web.common.framework.ajax;

import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;


public class AjaxHandlerMapping extends AbstractDetectingUrlHandlerMapping {

	static final String USE_DEFAULT_SUFFIX_PATTERN = AjaxHandlerMapping.class
			.getName() + ".useDefaultSuffixPattern";

	private boolean useDefaultSuffixPattern = true;

	private final Map<Class<?>, Ajax> cachedMappings = new HashMap<Class<?>, Ajax>();

	public void setUseDefaultSuffixPattern(boolean useDefaultSuffixPattern) {
		this.useDefaultSuffixPattern = useDefaultSuffixPattern;
	}

	/**
	 * Checks for presence of the
	 * {@link org.springframework.web.bind.annotation.RequestMapping} annotation
	 * on the handler class and on any of its methods.
	 */
	@Override
	protected String[] determineUrlsForHandler(String beanName) {
		ApplicationContext context = getApplicationContext();
		Class<?> handlerType = context.getType(beanName);
		Ajax mapping = context.findAnnotationOnBean(beanName, Ajax.class);
		if (mapping != null) {
			// @RequestMapping found at type level
			this.cachedMappings.put(handlerType, mapping);
			Set<String> urls = new LinkedHashSet<String>();
			String[] typeLevelPatterns = mapping.url();
			if (typeLevelPatterns.length > 0) {
				// @RequestMapping specifies paths at type level
				String[] methodLevelPatterns = determineUrlsForHandlerMethods(
						handlerType, true);
				for (String typeLevelPattern : typeLevelPatterns) {
					if (!typeLevelPattern.startsWith("/")) {
						typeLevelPattern = "/" + typeLevelPattern;
					}
					boolean hasEmptyMethodLevelMappings = false;
					for (String methodLevelPattern : methodLevelPatterns) {
						if (methodLevelPattern == null) {
							hasEmptyMethodLevelMappings = true;
						} else {
							String combinedPattern = getPathMatcher().combine(
									typeLevelPattern, methodLevelPattern);
							addUrlsForPath(urls, combinedPattern);
						}
					}
					if (hasEmptyMethodLevelMappings
							|| org.springframework.web.servlet.mvc.Controller.class
									.isAssignableFrom(handlerType)) {
						addUrlsForPath(urls, typeLevelPattern);
					}
				}
				return StringUtils.toStringArray(urls);
			} else {
				// actual paths specified by @RequestMapping at method level
				return determineUrlsForHandlerMethods(handlerType, false);
			}
		} else if (AnnotationUtils
				.findAnnotation(handlerType, Controller.class) != null) {
			// @RequestMapping to be introspected at method level
			return determineUrlsForHandlerMethods(handlerType, false);
		} else {
			return null;
		}
	}

	/**
	 * Derive URL mappings from the handler's method-level mappings.
	 * 
	 * @param handlerType
	 *            the handler type to introspect
	 * @param hasTypeLevelMapping
	 *            whether the method-level mappings are nested within a
	 *            type-level mapping
	 * @return the array of mapped URLs
	 */
	protected String[] determineUrlsForHandlerMethods(Class<?> handlerType,
			final boolean hasTypeLevelMapping) {
		String[] subclassResult = determineUrlsForHandlerMethods(handlerType);
		if (subclassResult != null) {
			return subclassResult;
		}

		final Set<String> urls = new LinkedHashSet<String>();
		Set<Class<?>> handlerTypes = new LinkedHashSet<Class<?>>();
		handlerTypes.add(handlerType);
		handlerTypes.addAll(Arrays.asList(handlerType.getInterfaces()));
		for (Class<?> currentHandlerType : handlerTypes) {
			ReflectionUtils.doWithMethods(currentHandlerType,
					new ReflectionUtils.MethodCallback() {
						public void doWith(Method method) {
							Ajax mapping = AnnotationUtils.findAnnotation(
									method, Ajax.class);
							if (mapping != null) {
								String[] mappedPatterns = mapping.url();
								if (mappedPatterns.length > 0) {
									for (String mappedPattern : mappedPatterns) {
										if (!hasTypeLevelMapping
												&& !mappedPattern
														.startsWith("/")) {
											mappedPattern = "/" + mappedPattern;
										}
										addUrlsForPath(urls, mappedPattern);
									}
								} else if (hasTypeLevelMapping) {
									// empty method-level RequestMapping
									urls.add(null);
								}
							}
						}
					}, ReflectionUtils.USER_DECLARED_METHODS);
		}
		return StringUtils.toStringArray(urls);
	}

	/**
	 * Derive URL mappings from the handler's method-level mappings.
	 * 
	 * @param handlerType
	 *            the handler type to introspect
	 * @return the array of mapped URLs
	 */
	protected String[] determineUrlsForHandlerMethods(Class<?> handlerType) {
		return null;
	}

	/**
	 * Add URLs and/or URL patterns for the given path.
	 * 
	 * @param urls
	 *            the Set of URLs for the current bean
	 * @param path
	 *            the currently introspected path
	 */
	protected void addUrlsForPath(Set<String> urls, String path) {
		urls.add(path);
		if (this.useDefaultSuffixPattern && path.indexOf('.') == -1
				&& !path.endsWith("/")) {
			urls.add(path + ".*");
			urls.add(path + "/");
		}
	}

	/**
	 * Validate the given annotated handler against the current request.
	 * 
	 * @see #
	 */
	@Override
	protected void validateHandler(Object handler, HttpServletRequest request)
			throws Exception {
		Ajax mapping = this.cachedMappings.get(handler.getClass());
		if (mapping == null) {
			mapping = AnnotationUtils.findAnnotation(handler.getClass(),
					Ajax.class);
		}
		request.setAttribute(USE_DEFAULT_SUFFIX_PATTERN,
				this.useDefaultSuffixPattern);
	}

	@Override
	protected boolean supportsTypeLevelMappings() {
		return true;
	}

}
