package org.cleverframework.infrastructure.dependency;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * bean  容器
 */
public class BeanContainer {

    private static Map<String, Object> nameBeanMaps = Maps.newHashMap();


    public <T> T get(String name) {

        throw new UnsupportedOperationException();
    }


    public <T> T get(Class<?> requiredType) {

        throw new UnsupportedOperationException();
    }

    public Object get(String name, Class<?> requiredType) {

        throw new UnsupportedOperationException();
    }

    public <T> BeanContainer add(String name, T object) {

        return this;
    }

    public <T> BeanContainer add(Class<?> objectType, T object) {

        return this;
    }
}
