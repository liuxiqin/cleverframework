package org.cleverframework.annotation;

import java.lang.annotation.*;

/**
 * 消息监听的TOPIC(主题)与 CONSUMER GROUP(消费组)
 * TOPIC:在不同的环境都会加上前缀:eg.test-user,demo-user,prod-user
 * CONSUMER-GROUP:在不同的环境都会加上前缀,eg,CID_TEST_USER, CID_DEMO_USER, CID_PROD_DEMO
 *
 * @author liuxiqin
 */
@Target({ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

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
