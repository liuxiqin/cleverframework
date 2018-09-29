package org.cleverframework.messages;

/**
 * 消息消费者接口抽象
 */
public interface MessageConsumer {

    /**
     * 启动
     *
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * 关闭
     *
     * @throws Exception
     */
    void close() throws Exception;

    /**
     * 消费者名称
     *
     * @return
     */
    String getName();
}
