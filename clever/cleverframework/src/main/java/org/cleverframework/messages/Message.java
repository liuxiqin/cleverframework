package org.cleverframework.messages;

import org.cleverframework.common.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 消息抽象类|[事件消息，命令消息]
 */
public abstract class Message implements Serializable {

    protected String identityId;

    private long timestamp;

    private Map<String, Object> attributes;

    public Message() {

        identityId = ObjectId.getNextId();
        timestamp = new Date().getTime();
    }

    public String getId() {
        return this.identityId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
