package org.cleverframework.messages.reply;

import org.cleverframework.messages.MessageHandlerResult;

/**
 * 消息请求接口实现
 *
 * @author xiqin.liu
 */
public class MessageReplyImpl implements MessageReply {

    private MessageHandlerResult messageHandlerResult;

    private long timeout;

    private String messageId;

    public MessageReplyImpl(String messageId, long timeout) {

        this.messageId = messageId;
        this.timeout = timeout;
    }

    @Override
    public MessageHandlerResult getResult() {
        return null;
    }

    @Override
    public void setResult(MessageHandlerResult result) {

    }
}
