package org.cleverframework.messages.request;

import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.channels.CommunicateChannelFactoryPool;
import org.cleverframework.messages.reply.MessageReply;
import org.cleverframework.messages.reply.MessageReplyPool;

import java.util.concurrent.Callable;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/29 17:19
 */
public class SendAsyncMessageTask implements Callable<Boolean> {

    private MessageWrapper messageWrapper;

    private long timeout = 3000;

    private CommunicateChannelFactoryPool communicateChannelFactoryPool;

    public SendAsyncMessageTask(CommunicateChannelFactoryPool communicateChannelFactoryPool, MessageWrapper messageWrapper) {

        this.communicateChannelFactoryPool = communicateChannelFactoryPool;
        this.messageWrapper = messageWrapper;
        this.timeout = timeout;
    }

    @Override
    public Boolean call()  {

        try {
            communicateChannelFactoryPool.getChannel().publish(messageWrapper);

            return Boolean.TRUE;

        } catch (Exception e) {

        }
        return Boolean.FALSE;
    }
}
