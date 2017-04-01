package org.cleverframework.eventhanding;

import org.cleverframework.events.Event;

public interface EventHandler<TEvent extends Event> {

    <TEvent> void handle(TEvent event);
}
