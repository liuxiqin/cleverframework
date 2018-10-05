package org.cleverframework.eventhandings;

import org.cleverframework.events.Event;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 16:09
 */
public class EventProcessorContext {

    private Event event;

    private EventHandler eventHandler;

    public EventProcessorContext(Event event) {
        this.event = event;
    }

    public Event getEvent() {

        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
}
