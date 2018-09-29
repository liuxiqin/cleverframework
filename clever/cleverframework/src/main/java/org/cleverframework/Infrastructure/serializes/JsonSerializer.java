package org.cleverframework.infrastructure.serializes;

/**
 * Created by Administrator on 2017-04-02 .
 */
public interface JsonSerializer {

    <T> String serialize(T object) throws Exception;

    <T> T deSerialize(String json, Class<T> beanClass);

    <T> T deSerializes(String json, Class<T> beanClass);
}
