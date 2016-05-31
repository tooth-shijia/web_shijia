package com.shijia.web.common.framework.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.List;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class ViewConfigurer extends FreeMarkerConfigurer{

    @Override
    protected void postProcessTemplateLoaders(List<TemplateLoader> templateLoaders) {
        templateLoaders.add(new ClassTemplateLoader(ViewConfigurer.class,""));
    }

    @Override
    protected void postProcessConfiguration(Configuration config) throws IOException, TemplateException {
        DirectiveUtils.exposeRapidMacros(config);
        config.setClassicCompatible(true);
    }

}
