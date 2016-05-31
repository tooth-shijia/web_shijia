package com.shijia.web.common.framework.freemarker;

import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by lianfang.tan on 16/3/8.
 */
public class ViewPageResolver extends FreeMarkerViewResolver {
    private ViewStaticMethod viewStaticMethod;


    public ViewStaticMethod getViewStaticMethod() {
        return viewStaticMethod;
    }


    public void setViewStaticMethod(ViewStaticMethod viewStaticMethod) {
        this.viewStaticMethod = viewStaticMethod;
    }


    @Override
    protected void initApplicationContext() {

        super.initApplicationContext();
        this.setAttributesMap(viewStaticMethod.getStaticList());

    }
}
