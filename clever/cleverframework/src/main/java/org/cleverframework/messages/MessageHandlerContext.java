package org.cleverframework.messages;

import org.cleverframework.messages.channels.MessageChannel;

import java.io.Serializable;

/**
 * 消息处理上下文
 *
 * @author xiqin.liu
 */
public class MessageHandlerContext implements Serializable {

    private static final long serialVersionUID = -4546253438746170496L;

    private MessageHandlerResult handlerResult;

    private final MessageWrapper messageWrapper;

    private Message message;

    public MessageHandlerContext(MessageWrapper messageWrapper) {
        this.messageWrapper = messageWrapper;
    }

    public MessageHandlerResult getHandlerResult() {
        return handlerResult;
    }

    public void setHandlerResult(MessageHandlerResult handlerResult) {
        this.handlerResult = handlerResult;
    }

    public MessageWrapper getMessageWrapper() {
        return messageWrapper;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

