package org.cleverframework.messages;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息ClassName 与Class的映射存储容器
 *
 * @author xiqin.liu
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
        if (!classMaps.containsKey(className)) {
            return null;
        }

        return classMaps.get(className);
    }

}
