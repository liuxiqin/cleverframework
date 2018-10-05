package org.cleverframework.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.cleverframework.common.ObjectId;

import java.io.Serializable;
import java.util.Map;

/**
 * 消息抽象类|[事件消息，命令消息]
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "jsonMessageType")
public abstract class Message implements Serializable {

    protected String messageId;

    private long timestamp;

    private Map<String, Object> attributes;

    public Message() {

        messageId = ObjectId.getNextId();
        timestamp = System.currentTimeMillis();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String routingKey() {
        return this.messageId;
    }
}
