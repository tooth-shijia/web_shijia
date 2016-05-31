package com.shijia.web.common.framework.freemarker.selftag;

import com.shijia.web.common.framework.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class TemplateDirectiveBodyOverrideWraper implements TemplateDirectiveBody,TemplateModel {
    private TemplateDirectiveBody body;
    public TemplateDirectiveBodyOverrideWraper parentBody;
    public Environment env;

    public TemplateDirectiveBodyOverrideWraper(TemplateDirectiveBody body,
                                               Environment env) {
        super();
        this.body = body;
        this.env = env;
    }

    public void render(Writer out) throws TemplateException, IOException {
        if(body == null) return;
        TemplateDirectiveBodyOverrideWraper preOverridy = (TemplateDirectiveBodyOverrideWraper)env.getVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE);
        try {
            env.setVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE, this);
            body.render(out);
        }finally {
            env.setVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE, preOverridy);
        }
    }
}
