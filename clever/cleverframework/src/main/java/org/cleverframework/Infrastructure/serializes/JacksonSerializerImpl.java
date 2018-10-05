package org.cleverframework.infrastructure.serializes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cleverframework.common.ObjectId;
import org.cleverframework.infrastructure.exceptions.serializer.JsonDeSerializerException;
import org.cleverframework.infrastructure.exceptions.serializer.JsonSerializerException;

import java.io.IOException;
import java.util.Arrays;

/**
 * jackson json serializer
 *
 * @author xiqin.liu
 */
public class JacksonSerializerImpl implements JsonSerializer {

    private ObjectMapper objectMapper = new ObjectMapper();

    public JacksonSerializerImpl() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

    @Override
    public <T> String serialize(T object) {

        try {
            return objectMapper.writeValueAsString(object);

        } catch (Exception e) {

            throw new JsonSerializerException(e);
        }
    }

    @Override
    public <T> T deSerialize(String json, Class<T> beanClass) {

        try {

            return (T) objectMapper.readValue(json, beanClass);

        } catch (Exception e) {

            throw new JsonDeSerializerException(json, e);
        }
    }

    @Override
    public <T> T deSerializes(String json, Class<T> beanClass) {

        try {
            return (T) objectMapper.readValue(json, beanClass);

        } catch (Exception e) {

            throw new JsonDeSerializerException(json, e);
        }
    }

    @Override
    public <T> byte[] toBytes(T object) {


        if (null == object) {
            return new byte[0];
        }

        try {
            return objectMapper.writeValueAsBytes(object);

        } catch (Exception e) {

            throw new JsonSerializerException(e);
        }
    }

    @Override
    public <T> T deSerialize(byte[] bytes, Class<T> beanClass) {

        try {
            return objectMapper.readValue(bytes, beanClass);
        } catch (IOException e) {

            throw new JsonDeSerializerException(bytes, e);
        }
    }
}
