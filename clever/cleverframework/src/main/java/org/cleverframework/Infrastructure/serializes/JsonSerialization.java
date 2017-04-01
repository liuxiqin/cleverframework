package org.cleverframework.Infrastructure.serializes;

import java.util.List;

/**
 * Created by Administrator on 2017-04-02 .
 */
public interface JsonSerialization {

    <T> String serialize(T object);

    <T> T deSerialize(String json);

}
