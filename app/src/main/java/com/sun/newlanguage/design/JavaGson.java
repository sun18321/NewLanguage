package com.sun.newlanguage.design;

import com.google.gson.Gson;
import com.sun.newlanguage.bean.TestBean;

public class JavaGson {

    public TestBean getBean() {
        String json = "{\"name\":\"bryant\"}";
        Gson gson = new Gson();
        TestBean bean = gson.fromJson(json, TestBean.class);
        return bean;
    }
}
