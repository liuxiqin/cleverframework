package org.cleverframework.messages.request;


import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.reply.MessageReply;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 消息请求抽象类
 *
 * @author xiqin.liu
 */
public interface MessageRequest {

    /**
     * 发送消息，异步发送，获取结果
     *
     * @param messageWrapper
     * @param timeout
     * @return
     */
    Future<MessageReply> send(MessageWrapper messageWrapper, long timeout);

    /**
     * 发送消息，异步发送
     *
     * @param messageWrapper
     * @return
     */
    Future sendAsync(MessageWrapper messageWrapper);
}
