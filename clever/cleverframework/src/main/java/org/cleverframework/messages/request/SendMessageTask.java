package org.cleverframework.messages.request;

import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.channels.CommunicateChannelFactoryPool;
import org.cleverframework.messages.reply.MessageReply;
import org.cleverframework.messages.reply.MessageReplyPool;

import java.util.concurrent.Callable;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/29 16:28
 */
public class SendMessageTask implements Callable<MessageReply> {

    private MessageWrapper messageWrapper;

    private long timeout;

    private CommunicateChannelFactoryPool communicateChannelFactoryPool;

    public SendMessageTask(CommunicateChannelFactoryPool communicateChannelFactoryPool, MessageWrapper messageWrapper, long timeout) {

        this.communicateChannelFactoryPool = communicateChannelFactoryPool;
        this.messageWrapper = messageWrapper;
        this.timeout = timeout;
    }

    @Override
    public MessageReply call() throws Exception {

        communicateChannelFactoryPool.getChannel().publish(messageWrapper);

        return MessageReplyPool.tryAddMessageReply(messageWrapper.getMessageId(), timeout);
    }
}