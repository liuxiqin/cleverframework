package org.cleverframework.infrastructure.serializes;


/**
 * 二进制系列化与反序列化接口抽象
 *
 * @author xiqin.liu
 */
public interface BinarySerializer {

    /**
     * 二进制系列化
     *
     * @param object
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T object);

    /**
     * 二进制方反序列化
     *
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deSerialize(byte[] bytes);
}

