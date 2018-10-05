package org.cleverframework.infrastructure.serializes;

/**
 * JSON 系列化与反序列化接口
 *
 * @author xiqin.liu
 */
public interface JsonSerializer {

    /**
     * JSON系列化
     *
     * @param object
     * @param <T>
     * @return
     */
    <T> String serialize(T object);

    /**
     * JSON 反序列化
     *
     * @param json
     * @param beanClass
     * @param <T>
     * @return
     */
    <T> T deSerialize(String json, Class<T> beanClass);

    /**
     * JSON 批量反序列化
     *
     * @param json
     * @param beanClass
     * @param <T>
     * @return
     */
    <T> T deSerializes(String json, Class<T> beanClass);

    /**
     * Object to byte[]
     *
     * @param object object
     * @param <T>
     * @return
     */
    <T> byte[] toBytes(T object);

    /**
     * byte[] to Object
     *
     * @param bytes
     * @param beanClass
     * @param <T>
     * @return
     */
    <T> T deSerialize(byte[] bytes, Class<T> beanClass);
}
