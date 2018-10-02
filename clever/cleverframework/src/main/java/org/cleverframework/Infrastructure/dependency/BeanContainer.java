package org.cleverframework.infrastructure.dependency;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * bean  容器
 */
public class BeanContainer {

    private static Map<String, Object> nameBeanMaps = Maps.newHashMap();


    public Object get(String name) {

        throw new UnsupportedOperationException();
    }


    public Object get(Class requiredType) {

        throw new UnsupportedOperationException();
    }

    public Object get(String name, Class requiredType) {

        throw new UnsupportedOperationException();
    }

    public void add(String name, Object o) {
    }

    public void add(Class objectType, Object o) {
    }
}
