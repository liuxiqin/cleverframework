package org.cleverframework.messages;


import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.channels.CommunicateChannelFactoryPool;

import java.util.List;

/**
 * 发送消息实现
 *
 * @author xiqin.liu
 */
public class MessageProducerImpl implements MessageProducer {

    private JsonSerializer jsonSerializer;

    private CommunicateChannelFactoryPool communicateChannelFactoryPool;

    public MessageProducerImpl(JsonSerializer jsonSerializer, CommunicateChannelFactoryPool communicateChannelFactoryPool) {

        this.communicateChannelFactoryPool = communicateChannelFactoryPool;
        this.jsonSerializer = jsonSerializer;

    }

    @Override
    public void send(MessageWrapper messageWrapper) {

        communicateChannelFactoryPool.getChannel().publish(messageWrapper);
    }

    @Override
    public void send(List<MessageWrapper> messageWrappers) {


    }
}
