package org.cleverframework.infrastructure.exceptions.serializer;

/**
 * JSON 反序列化异常
 */
public class JsonDeSerializerException extends RuntimeException {

    public JsonDeSerializerException(Exception e) {
        super("JSON反序列化异常", e);
    }
}
