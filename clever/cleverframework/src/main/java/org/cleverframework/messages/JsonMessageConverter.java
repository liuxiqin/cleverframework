package org.cleverframework.messages;

import org.cleverframework.infrastructure.serializes.JsonSerializer;

/**
 * JSON消息转换实现
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/5 14:24
 */
public class JsonMessageConverter implements MessageConverter {

    private JsonSerializer jsonSerializer;

    public JsonMessageConverter(JsonSerializer jsonSerializer) {

        this.jsonSerializer = jsonSerializer;
    }


    @Override
    public <T> T toObject(String message, Class<?> tClass) {

        if (null == message) {
            throw new IllegalArgumentException("message can not be null or empty.");
        }

        return (T) jsonSerializer.deSerialize(message, tClass);
    }

    @Override
    public <T> String toString(T message) {

        if (null == message) {
            throw new IllegalArgumentException("message can not be null.");
        }

        return jsonSerializer.serialize(message);
    }

    @Override
    public <T> byte[] toBytes(T message) {

        if (null == message) {
            throw new IllegalArgumentException("message can not be null.");
        }

        return jsonSerializer.toBytes(message);
    }

    @Override
    public <T> T toObject(byte[] bytes, Class<?> tClass) {

        if (null == bytes || bytes.length < 1) {
            throw new IllegalArgumentException("bytes can not be null.");
        }

        return (T) jsonSerializer.deSerialize(bytes, tClass);
    }

}
