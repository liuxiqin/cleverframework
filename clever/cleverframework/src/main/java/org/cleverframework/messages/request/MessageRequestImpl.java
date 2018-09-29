package org.cleverframework.messages.request;

import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.channels.CommunicateChannelFactoryPool;
import org.cleverframework.messages.reply.MessageReply;

import java.util.concurrent.*;

/**
 * @author xiqin.liu
 */
public class MessageRequestImpl implements MessageRequest {

    private CommunicateChannelFactoryPool communicateChannelFactoryPool;

    private ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public Future<MessageReply> send(MessageWrapper messageWrapper, long timeout) {

        Callable<MessageReply> callable = new SendMessageTask(communicateChannelFactoryPool, messageWrapper, timeout);

        FutureTask<MessageReply> sendTask = new FutureTask<>(callable);

        MessageReply reply = null;

        Future<MessageReply> future = executor.submit(sendTask, reply);

        return future;

    }

    @Override
    public Future<?> sendAsync(MessageWrapper messageWrapper) {

        Callable<Boolean> callable = new SendAsyncMessageTask(communicateChannelFactoryPool, messageWrapper);

        FutureTask<Boolean> sendTask = new FutureTask<>(callable);

        return executor.submit(sendTask);
    }
}
