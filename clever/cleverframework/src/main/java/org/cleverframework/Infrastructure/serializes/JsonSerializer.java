package org.cleverframework.Infrastructure.serializes;

import java.util.List;

/**
 * Created by Administrator on 2017-04-02 .
 */
public interface JsonSerializer {

    <T> String serialize(T object) throws Exception;

    <T> T deSerialize(String json) throws Exception;

}
