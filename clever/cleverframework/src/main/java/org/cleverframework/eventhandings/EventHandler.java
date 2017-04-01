package org.cleverframework.eventhandings;

import org.cleverframework.events.Event;

public interface EventHandler<TEvent extends Event> {

    void handle(TEvent event);
}
 
