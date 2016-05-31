package com.shijia.web.common.framework.freemarker.selftag;

import com.shijia.web.common.framework.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class SuperDirective implements TemplateDirectiveModel{
    public final static String DIRECTIVE_NAME = "super";

    @SuppressWarnings("rawtypes")

    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        // TODO Auto-generated method stub
        TemplateDirectiveBodyOverrideWraper current = (TemplateDirectiveBodyOverrideWraper)env.getVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE);
        if(current == null) {
            throw new TemplateException("<@super/> direction must be child of override", env);
        }
        TemplateDirectiveBody parent = current.parentBody;
        if(parent == null) {
            throw new TemplateException("not found parent for <@super/>", env);
        }
        parent.render(env.getOut());
    }
}
