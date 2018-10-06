package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.eventhandings.EventHandler;
import org.cleverframework.events.Event;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/6 16:16
 */
public class EventHandlerFailException extends RuntimeException {

    public EventHandlerFailException(EventHandler eventHandler, Event event, Exception e) {

        super("事件处理失败，EventHandler:" + eventHandler.toString() + ",Event:", e);
    }
}
