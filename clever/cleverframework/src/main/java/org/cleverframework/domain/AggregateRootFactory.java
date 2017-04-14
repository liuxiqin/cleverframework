package org.cleverframework.domain;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

/**
 * Created by Administrator on 2017-04-14 .
 */
public class AggregateRootFactory {

    public static Objenesis objenesis = new ObjenesisStd();

    public static ObjectInstantiator objectInstantiator = objenesis.getInstantiatorOf(AggregateRoot.class);

    public static AggregateRoot createNew() {

        return (AggregateRoot) objectInstantiator.newInstance();

    }
}
