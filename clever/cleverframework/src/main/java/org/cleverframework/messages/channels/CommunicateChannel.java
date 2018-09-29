package org.cleverframework.messages.channels;

import org.cleverframework.messages.MessageWrapper;

/**
 * 消息发送通道
 */
public interface CommunicateChannel {

    void publish(MessageWrapper message);

    void close();
}
