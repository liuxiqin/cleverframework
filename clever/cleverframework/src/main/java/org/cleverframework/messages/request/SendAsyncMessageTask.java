package org.cleverframework.messages.request;

import org.cleverframework.messages.MessageProducer;
import org.cleverframework.messages.MessageWrapper;

import java.util.concurrent.Callable;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/29 17:19
 */
public class SendAsyncMessageTask implements Callable<Boolean> {

    private MessageWrapper messageWrapper;

    private long timeout = 3000;

    private MessageProducer messageProducer;

    public SendAsyncMessageTask(MessageProducer messageProducer, MessageWrapper messageWrapper) {

        this.messageProducer = messageProducer;
        this.messageWrapper = messageWrapper;
        this.timeout = timeout;
    }

    @Override
    public Boolean call() {

        try {

            messageProducer.send(messageWrapper);

            return Boolean.TRUE;

        } catch (Exception e) {


        }
        return Boolean.FALSE;
    }
}
