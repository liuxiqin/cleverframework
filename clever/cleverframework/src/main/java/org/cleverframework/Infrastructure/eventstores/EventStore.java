package org.cleverframework.Infrastructure.eventstores;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface EventStore {

    void appendEventsToStream(EventStreamRecord eventStream);

    EventStream get(String aggregateRootId, int version) ;
}

