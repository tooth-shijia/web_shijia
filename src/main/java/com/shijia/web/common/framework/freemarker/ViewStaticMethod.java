package com.shijia.web.common.framework.freemarker;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModelException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lianfang.tan on 16/3/8.
 */
public class ViewStaticMethod {
    @SuppressWarnings("rawtypes")
    private List<String> classList = new ArrayList<String>();

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    @SuppressWarnings("rawtypes")
    public Map<String, Object> getStaticList() {

        Map<String, Object> methodList = new HashMap<String, Object>();

        try {

            for (String name : classList) {
                Class clz = Class.forName(name);
                methodList.put(clz.getSimpleName(), getStaticModel(clz));
            }
        } catch (Exception ex) {

        }
        return methodList;
    }

    @SuppressWarnings("rawtypes")
    private Object getStaticModel(Class clz) {
        BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
        try {
            return wrapper.getStaticModels().get(clz.getName());
        } catch (TemplateModelException e) {
            //e.printStackTrace();
        }
        return null;
    }
}
