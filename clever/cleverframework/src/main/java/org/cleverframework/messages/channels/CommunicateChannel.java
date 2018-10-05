package org.cleverframework.messages.channels;

import org.cleverframework.messages.MessageWrapper;

import java.util.List;

/**
 * 消息发送通道
 */
public interface CommunicateChannel {

    void publish(MessageWrapper message);

    void publish(List<MessageWrapper> messages);

    void close();
}
