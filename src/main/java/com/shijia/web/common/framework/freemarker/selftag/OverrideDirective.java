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
public class OverrideDirective implements TemplateDirectiveModel{
    public final static String DIRECTIVE_NAME = "override";
    @SuppressWarnings("rawtypes")

    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        // TODO Auto-generated method stub
        String name = DirectiveUtils.getRequiredParam(params, "name");
        String overrideVariableName = DirectiveUtils.getOverrideVariableName(name);

        TemplateDirectiveBodyOverrideWraper override = DirectiveUtils.getOverrideBody(env, name);
        TemplateDirectiveBodyOverrideWraper current = new TemplateDirectiveBodyOverrideWraper(body,env);
        if(override == null) {
            env.setVariable(overrideVariableName, current);
        }else {
            DirectiveUtils.setTopBodyForParentBody(env, current, override);
        }
    }
}
