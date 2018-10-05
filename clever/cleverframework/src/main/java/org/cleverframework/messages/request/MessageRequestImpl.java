package org.cleverframework.messages.request;

import org.cleverframework.messages.MessageProducer;
import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.reply.MessageReply;

import java.util.concurrent.*;

/**
 * 消息请求接口实现
 *
 * @author xiqin.liu
 */
public class MessageRequestImpl implements MessageRequest {

    private MessageProducer messageProducer;

    private ExecutorService executor = Executors.newCachedThreadPool();

    public MessageRequestImpl(MessageProducer messageProducer) {

        this.messageProducer = messageProducer;
    }

    @Override
    public Future<MessageReply> send(MessageWrapper messageWrapper, long timeout) {

        Callable<MessageReply> callable = new SendMessageTask(messageProducer, messageWrapper, timeout);

        FutureTask<MessageReply> sendTask = new FutureTask<>(callable);

        MessageReply reply = null;

        Future<MessageReply> future = executor.submit(sendTask, reply);

        return future;

    }

    @Override
    public Future<?> sendAsync(MessageWrapper messageWrapper) {

        Callable<Boolean> callable = new SendAsyncMessageTask(messageProducer, messageWrapper);

        FutureTask<Boolean> sendTask = new FutureTask<>(callable);

        return executor.submit(sendTask);
    }
}
