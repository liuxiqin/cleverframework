package org.cleverframework.infrastructure.exceptions.serializer;

/**
 * 二进制序列化异常
 *
 * @author xiqin.liu
 */
public class BinarySerializerException extends RuntimeException {

    public BinarySerializerException(Exception e) {

        super("二进制序列化异常", e);
    }
}

