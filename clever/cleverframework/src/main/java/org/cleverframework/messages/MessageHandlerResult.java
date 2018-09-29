package org.cleverframework.messages;

import java.io.Serializable;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/29 14:56
 */
public class MessageHandlerResult implements Serializable {

    private static final long serialVersionUID = -5351900285162190139L;

    private String messageId;

    private MessageHandlerStatus status;

    private String message;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public MessageHandlerStatus getStatus() {
        return status;
    }

    public void setStatus(MessageHandlerStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageHandlerResult:{" +
                "message='" + message + '\'' +
                ", status =" + status +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}