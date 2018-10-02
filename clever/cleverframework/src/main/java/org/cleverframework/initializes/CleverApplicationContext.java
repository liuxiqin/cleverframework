package org.cleverframework.initializes;

import org.cleverframework.infrastructure.dependency.BeanContainer;

/**
 * 框架 上下文，扩展和外边系统集成
 *
 * @author xiqin.liu
 */
public class CleverApplicationContext {

    private static BeanContainer beanContainer = new BeanContainer();

    public static BeanContainer getBeanContainer() {

        return beanContainer;
    }
}
