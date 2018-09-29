package org.cleverframework.infrastructure.eventstores;

import java.io.Serializable;

/**
 * 事件流记录
 */
public class EventStreamRecord implements Serializable {

    private int version;

    private String aggregateRootId;

    private String commandId;

    private byte[] eventBytes;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public byte[] getEventBytes() {
        return eventBytes;
    }

    public void setEventBytes(byte[] eventBytes) {
        this.eventBytes = eventBytes;
    }
}
