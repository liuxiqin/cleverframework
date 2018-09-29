package org.cleverframework.messages;

/**
 * 消息发送接口抽象
 */
public interface MessageProducer {

    void send(MessageWrapper messageWrapper) throws Exception;
}
