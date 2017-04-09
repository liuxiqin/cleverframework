package org.cleverframework.Infrastructure.serializes;

import java.io.IOException;

/**
 * Created by Administrator on 2017-04-09 .
 */
public interface BinarySerializer {

    <T> byte[] serialize(T object) throws IOException;

    <T> T deSerialize(byte[] bytes) throws Exception;
}

