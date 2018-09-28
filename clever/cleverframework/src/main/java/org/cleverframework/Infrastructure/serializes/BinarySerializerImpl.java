package org.cleverframework.infrastructure.serializes;

import org.cleverframework.infrastructure.exceptions.serializer.BinarySerializerException;

import java.io.*;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class BinarySerializerImpl implements BinarySerializer {

    public <T> byte[] serialize(T object) throws IOException {

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

    public <T> T deSerialize(byte[] bytes) throws Exception {

        if (bytes == null || bytes.length == 0)
            return null;

        InputStream inputStream = new ByteArrayInputStream(bytes);

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (T) objectInputStream.readObject();
    }
}
