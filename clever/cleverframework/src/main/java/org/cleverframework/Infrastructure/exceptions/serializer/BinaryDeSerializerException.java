package org.cleverframework.infrastructure.exceptions.serializer;

/**
 * 二进制反序列化异常
 *
 * @author xiqin.liu
 */
public class BinaryDeSerializerException extends RuntimeException {


    public BinaryDeSerializerException(Exception e) {

        super("二进制反序列化异常", e);
    }
}
