package org.cleverframework.messages;

import java.io.Serializable;

/**
 * 消息封装类
 *
 * @author xiqin.liu
 */
public class MessageWrapper implements Serializable {

    private static final long serialVersionUID = 8317408161383032451L;

    /**
     * 消息名称
     */
    private String messageName;

    /**
     * 消息ID
     */
    private String messageId;

    /**
     * 消息体
     */
    private Message messageBody;

    /**
     * 当前时间
     */
    private long timeStamp;

    /**
     * 消息体长度
     */
    private long bodyLength;

    /**
     * 消息路由键
     */
    private String routingKey;

    private Boolean needResponse;

    /**
     * 消息TOPIC
     */
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

    public Message getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Message messageBody) {
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
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public Boolean getNeedResponse() {
        return needResponse;
    }

    public void setNeedResponse(Boolean needResponse) {
        this.needResponse = needResponse;
    }

    @Override
    public String toString() {
        return "MessageWrapper:{" +
                "messageName='" + messageName + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", timeStamp=" + timeStamp +
                ", bodyLength=" + bodyLength +
                ", routingKey='" + routingKey + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
