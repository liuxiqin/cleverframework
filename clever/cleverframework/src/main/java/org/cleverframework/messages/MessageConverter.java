package org.cleverframework.messages;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 14:18
 */
public interface MessageConverter {

    /**
     * String转换为Message
     *
     * @param message
     * @param tClass
     * @return
     */
    <T> T toObject(String message, Class<?> tClass);

    /**
     * Message 转换为 String
     *
     * @param message Message
     * @return String
     */
    <T> String toString(T message);

    /**
     * Message 转换为byte 数组
     *
     * @param message Message
     * @return byte[]
     */
    <T> byte[] toBytes(T message);


    /**
     * byte[] 转换为 Message
     *
     * @param bytes  byte[]
     * @param tClass
     * @return Message
     */
    <T> T toObject(byte[] bytes, Class<?> tClass);
}
