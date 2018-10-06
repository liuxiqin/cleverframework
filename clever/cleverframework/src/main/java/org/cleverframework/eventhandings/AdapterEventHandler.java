package org.cleverframework.eventhandings;

import org.cleverframework.events.Event;
import org.cleverframework.infrastructure.exceptions.EventHandlerFailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/6 16:09
 */
public class AdapterEventHandler<TEvent extends Event> implements EventHandler<TEvent> {

    private final Logger logger = LoggerFactory.getLogger(AdapterEventHandler.class);

    private Object handlerObject;

    private Method handlerMethod;

    private String messageName;

    public AdapterEventHandler(Object handlerObject, Method handlerMethod, String eventName) {
        this.handlerMethod = handlerMethod;
        this.handlerObject = handlerObject;
        this.messageName = messageName;
    }

    @Override
    public void handle(TEvent event) {
        try {
            handlerMethod.invoke(handlerObject, event);
        } catch (Exception e) {
            throw new EventHandlerFailException(this, event, e);
        }
    }


    @Override
    public String toString() {

        return String.format("handlerObject:%s, handlerMethod:%s, class:%s", handlerObject.getClass().getName(), handlerMethod.getName(), this.messageName);
    }
}
