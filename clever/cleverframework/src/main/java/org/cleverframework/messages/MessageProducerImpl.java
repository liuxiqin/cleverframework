package org.cleverframework.messages;


import com.rabbitmq.client.*;
import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.channels.CommunicateChannel;

import java.util.List;

/**
 * 发送消息实现
 *
 * @author xiqin.liu
 */
public class MessageProducerImpl implements MessageProducer {

    private JsonSerializer binarySerializer;

    private CommunicateChannel communicateChannel;

    public MessageProducerImpl() {

    }

    @Override
    public void send(MessageWrapper messageWrapper) {


    }

    @Override
    public void send(List<MessageWrapper> messageWrappers) {


    }
}
