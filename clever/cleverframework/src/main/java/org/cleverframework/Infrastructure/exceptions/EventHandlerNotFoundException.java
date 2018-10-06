package org.cleverframework.infrastructure.exceptions;

/**
 * Created by Administrator on 2017-04-01 .
 */
public class EventHandlerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -742428769322884828L;

    public EventHandlerNotFoundException(String message) {
       super(message);
    }
}
