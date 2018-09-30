package org.cleverframework.infrastructure.serializes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cleverframework.infrastructure.exceptions.serializer.JsonDeSerializerException;
import org.cleverframework.infrastructure.exceptions.serializer.JsonSerializerException;

/**
 *
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

            throw new JsonDeSerializerException(e);
        }
    }

    @Override
    public <T> T deSerializes(String json, Class<T> beanClass) {

        try {
            return (T) objectMapper.readValue(json, beanClass);

        } catch (Exception e) {

            throw new JsonDeSerializerException(e);
        }
    }

}
