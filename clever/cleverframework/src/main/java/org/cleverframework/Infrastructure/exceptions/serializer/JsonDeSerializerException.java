package org.cleverframework.infrastructure.exceptions.serializer;

/**
 * JSON 反序列化异常
 *
 * @author xiqin.liu
 */
public class JsonDeSerializerException extends RuntimeException {

    public JsonDeSerializerException(Object o, Exception e) {
        super("JSON反序列化异常", e);
    }
}
