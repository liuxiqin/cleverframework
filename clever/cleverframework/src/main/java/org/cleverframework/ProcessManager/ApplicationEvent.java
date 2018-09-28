package org.cleverframework.processmanager;

import org.cleverframework.events.Event;

/**
 * 普通事件|非领域事件
 */
public abstract class ApplicationEvent extends Event {

    private String eventId;

    public ApplicationEvent(String eventId) {

        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }
}
