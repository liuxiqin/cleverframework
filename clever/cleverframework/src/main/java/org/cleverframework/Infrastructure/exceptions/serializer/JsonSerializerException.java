package org.cleverframework.infrastructure.exceptions.serializer;

/**
 * JSON 序列化异常
 */
public class JsonSerializerException extends RuntimeException {

    public JsonSerializerException(Exception e) {
        super("JSON序列化异常", e);
    }
}
