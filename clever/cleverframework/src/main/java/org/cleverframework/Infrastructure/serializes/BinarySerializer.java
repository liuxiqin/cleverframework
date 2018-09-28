package org.cleverframework.infrastructure.serializes;


/**
 * Created by Administrator on 2017-04-09 .
 */
public interface BinarySerializer {

    <T> byte[] serialize(T object);

    <T> T deSerialize(byte[] bytes);
}

