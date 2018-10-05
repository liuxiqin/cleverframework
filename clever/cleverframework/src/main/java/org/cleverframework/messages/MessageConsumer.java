package org.cleverframework.messages;

/**
 * 消息消费者接口抽象
 */
public interface MessageConsumer extends Runnable {

    /**
     * 启动
     */
    void start();

    /**
     * 关闭
     */
    void stop();

    /**
     * 消费者名称
     *
     * @return
     */
    String getName();
}
