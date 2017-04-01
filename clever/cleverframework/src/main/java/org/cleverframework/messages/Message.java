package org.cleverframework.messages;

import java.io.Serializable;
import java.util.Date;

import org.cleverframework.common.ObjectId;

/**
 * the abstract message
 */
public abstract class Message implements Serializable {

    protected String identityId;

    private long timestamp;

    private String createBy;

    public Message() {
        if (identityId == null || identityId.equals("")) {
            identityId = ObjectId.getNextId();
        }
        if (timestamp == 0) {
            timestamp = new Date().getTime();
        }
    }

    public Message(String messageId) {
        this.identityId = messageId;
        timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return this.identityId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
