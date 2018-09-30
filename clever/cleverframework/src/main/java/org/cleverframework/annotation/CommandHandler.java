package org.cleverframework.annotation;

import java.lang.annotation.*;

/**
 * 命令处理注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandHandler {

    /**
     * TOPIC主题
     *
     * @return
     */
    String topic();

    /**
     * 消费组
     *
     * @return
     */
    String consumerGroup();

    /**
     * 是否忽略
     *
     * @return
     */
    boolean ignore() default false;
}
