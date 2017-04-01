package org.cleverframework.eventhandings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.cleverframework.events.Event;

public class EventHandlerInvoker {

    private final Method method;

    private final String eventName;

    private final EventHandler handler;

    public EventHandlerInvoker(Method method, String eventName, EventHandler handler) {

        this.method = method;
        this.eventName = eventName;
        this.handler = handler;
    }

    public void invoke(Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        method.invoke(handler, event);
    }

    public void invoke(Object handle, Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        method.invoke(handle, event);
    }
}
