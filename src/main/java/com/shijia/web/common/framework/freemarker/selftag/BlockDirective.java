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
public class BlockDirective implements TemplateDirectiveModel {
    public final static String DIRECTIVE_NAME = "block";
    @SuppressWarnings("rawtypes")

    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        // TODO Auto-generated method stub
        String name = DirectiveUtils.getRequiredParam(params, "name");
        TemplateDirectiveBodyOverrideWraper overrideBody = DirectiveUtils.getOverrideBody(env, name);
        if(overrideBody == null) {
            if(body != null) {
                body.render(env.getOut());
            }
        }else {
            DirectiveUtils.setTopBodyForParentBody(env, new TemplateDirectiveBodyOverrideWraper(body,env), overrideBody);
            overrideBody.render(env.getOut());
        }

    }
}
