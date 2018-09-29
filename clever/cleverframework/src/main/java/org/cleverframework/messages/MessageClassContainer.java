package org.cleverframework.messages;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-16 .
 */
public class MessageClassContainer {

    private static Map<String, Class<?>> classMaps = new HashMap<>();

    public static void put(Class<?> beanClass) {

        if (classMaps.containsKey(beanClass.getName())) {
            return;
        }

        classMaps.put(beanClass.getName(), beanClass);

    }

    public static Class<?> get(String className) {
        if (!classMaps.containsKey(className))
            return null;

        return classMaps.get(className);
    }

}
