package org.cleverframework.infrastructure.eventstores;

import org.cleverframework.events.Event;

import java.util.List;

/**
 * 事件流
 */
public class EventStream {

    /**
     * 版本号
     */
    private int version;

    /**
     * 事件
     */
    private List<Event> events;

    /**
     * 聚合根ID
     */
    private String aggregateRootId;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }
}