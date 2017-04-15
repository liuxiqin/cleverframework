package org.cleverframework.messages;

import java.io.Serializable;
import java.util.Date;

public class MessageWrapper implements Serializable {

    private static final long serialVersionUID = 8317408161383032451L;

    private String messageName;

    private String messageId;

    private String messageBody;

    private long timeStamp;

    private long bodyLength;

    private String RoutingKey;

    private String topic;

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(long bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getRoutingKey() {
        return RoutingKey;
    }

    public void setRoutingKey(String routingKey) {
        RoutingKey = routingKey;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" +
                "messageName='" + messageName + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", timeStamp=" + timeStamp +
                ", bodyLength=" + bodyLength +
                ", RoutingKey='" + RoutingKey + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
