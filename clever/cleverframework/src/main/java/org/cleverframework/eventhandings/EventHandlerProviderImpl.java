package org.cleverframework.eventhandings;

import org.cleverframework.infrastructure.exceptions.EventHandlerNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/6 16:48
 */
public class EventHandlerProviderImpl implements EventHandlerProvider{


    private Map<String, EventHandler<?>> eventHandlers;

    public EventHandlerProviderImpl() {

        eventHandlers = new HashMap<>();
    }

    @Override
    public EventHandler getEventHandler(Class<?> eventClass) {

        if (!eventHandlers.containsKey(eventClass.getName())) {
            throw new EventHandlerNotFoundException("can not find this EventHandlerInvoker with the eventName->" + eventClass.getName());
        }

        return eventHandlers.get(eventClass.getName());
    }

    @Override
    public EventHandler<?> getEventHandler(String eventName) {

        if (!eventHandlers.containsKey(eventName)) {
            throw new EventHandlerNotFoundException("can not find this EventHandlerInvoker with the eventName->" + eventName);
        }

        return eventHandlers.get(eventName);
    }

}
