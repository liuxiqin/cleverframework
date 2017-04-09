package org.cleverframework.Infrastructure.eventstores;

import org.cleverframework.events.Event;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class EventStream{

    private int version;

    private List<Event> events;

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