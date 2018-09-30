package org.cleverframework.infrastructure.serializes;

import org.cleverframework.infrastructure.exceptions.serializer.BinarySerializerException;

import java.io.*;

/**
 * 二进制系列和反序列化实现
 *
 * @author xiqin.liu
 */
public class BinarySerializerImpl implements BinarySerializer {

    @Override
    public <T> byte[] serialize(T object) {

        if (object == null) {
            return null;
        }

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);

            objectOutputStream.writeObject(object);

            byte[] bytes = baos.toByteArray();

            return bytes;

        } catch (Exception e) {

            throw new BinarySerializerException(e);
        }
    }

    @Override
    public <T> T deSerialize(byte[] bytes) {

        if (bytes == null || bytes.length == 0) {
            return null;
        }

        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            return (T) objectInputStream.readObject();
        } catch (Exception e) {

            return null;
        }
    }
}
