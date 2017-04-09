package org.cleverframework.Infrastructure.eventstores;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface EventStore {

    void AppendEventsToStream(EventStream eventStream);
}

