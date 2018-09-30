package org.cleverframework.messages.channels;

import org.cleverframework.messages.MessageHandlerResult;

/**
 * 消息应答结果通道
 * 结果来源[消息队列，HTTP，NETTY]，都通过调用此结果与组件进行交互
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 11:09
 */
public interface MessageReplyChannel {

    /**
     * 消息处理结果应答
     *
     * @param result
     */
    void reply(MessageHandlerResult result);
}
