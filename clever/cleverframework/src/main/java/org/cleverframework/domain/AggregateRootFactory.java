package org.cleverframework.domain;

import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

/**
 * Created by Administrator on 2017-04-14 .
 */
public class AggregateRootFactory {

    public static Objenesis objenesis = new ObjenesisStd();

    public static ObjectInstantiator objectInstantiator = objenesis.getInstantiatorOf(AggregateRoot.class);

    public static BinarySerializer binarySerializer = new BinarySerializerImpl();

    public static <T extends AggregateRoot> T createNew() {

        return (T) objectInstantiator.newInstance();
    }

    public static <T extends AggregateRoot> T create() {
        return (T) new AggregateRoot();
    }

    public static <T extends AggregateRoot> T createNew(byte[] aggregateRootBytes) throws Exception {

        if (aggregateRootBytes == null || aggregateRootBytes.length == 0)
            return null;

        return binarySerializer.deSerialize(aggregateRootBytes);
    }
}
