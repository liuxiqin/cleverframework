package org.cleverframework.messages;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 是否需要应答
     */
    private Boolean needResponse;

    /**
     * 扩展属性
     */
    private Map<String, Object> attributes = new HashMap<>();

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

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public MessageWrapper addAttribute(String attributeId, Object attribute) {

        if (!attributes.containsKey(attributeId)) {

            attributes.put(attributeId, attribute);
        }

        return this;
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
