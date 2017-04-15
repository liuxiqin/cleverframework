package org.cleverframework.events;

import java.util.List;

/**
 * Created by cass02 on 2017/4/15.
 */
public interface EventPublisher {

    void publish(List<Event> events);

    void publish(Event event);
}
