package org.cleverframework.eventhandings;

import java.lang.reflect.Method;

/**
 *
 */
public class EventHandlerInvokerFactory {

    public static EventHandlerInvoker create(Method method, String eventName, EventHandler eventHandler) {

        return new EventHandlerInvoker(method, eventName, eventHandler);
    }
}
