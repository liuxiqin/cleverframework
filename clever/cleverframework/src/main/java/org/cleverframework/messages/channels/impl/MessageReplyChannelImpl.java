package org.cleverframework.messages.channels.impl;

import org.cleverframework.messages.MessageHandlerResult;
import org.cleverframework.messages.channels.MessageReplyChannel;
import org.cleverframework.messages.reply.MessageReply;
import org.cleverframework.messages.reply.MessageReplyPool;

/**
 * 消息应答通过实现
 * 取出正在等待结果的MessageReply，并通知[notifys]
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 11:16
 */
public class MessageReplyChannelImpl implements MessageReplyChannel {

    @Override
    public void reply(MessageHandlerResult result) {

        if (null == result) {
            return;
        }

        MessageReply reply = MessageReplyPool.getAndRemoveMessageReply(result.getMessageId());

        if (null == reply) {
            return;
        }

        reply.setResult(result);
    }
}
