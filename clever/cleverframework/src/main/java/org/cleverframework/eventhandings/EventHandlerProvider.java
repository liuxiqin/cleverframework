package org.cleverframework.eventhandings;

import org.cleverframework.Infrastructure.exceptions.NotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * the contains of EventHandlers
 */
public class EventHandlerProvider {

    private Map<String, EventHandler<?>> eventInvokers;

    public EventHandlerProvider() {

        eventInvokers = new HashMap<String, EventHandler<?>>();
    }

    public EventHandler<?> getEventHandler(String eventName) throws NotFoundException {
        if (!eventInvokers.containsKey(eventName))
            throw new NotFoundException("can not find this EventHandlerInvoker with the eventName->" + eventName);

        return eventInvokers.get(eventName);
    }

}
