package org.cleverframework.messages;

import java.util.List;

/**
 * 消息发送接口抽象
 *
 * @author xiqin.liu
 */
public interface MessageProducer {

    /**
     * 发送消息
     *
     * @param messageWrapper
     */
    void send(MessageWrapper messageWrapper);

    /**
     * 批量发送消息
     *
     * @param messageWrappers
     */
    void send(List<MessageWrapper> messageWrappers);
}
