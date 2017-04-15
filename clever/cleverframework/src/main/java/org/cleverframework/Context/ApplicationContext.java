package org.cleverframework.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cass02 on 2017/4/15.
 */
public class ApplicationContext {

    public static Map<String, Object> beans = new HashMap<String, Object>();

    public static <T> T getBean(String beanName) {
        return (T) beans.get(beanName);
    }

    public static void setBean(String beanName, Object bean) {
        beans.put(beanName, bean);
    }

    public static void setBean(Class<?> beanClass, Object bean) {
        beans.put(beanClass.getName(), bean);
    }

    public static <T> T getBean(Class<?> beanClass) {
        return (T) beans.get(beanClass.getName());
    }
}
