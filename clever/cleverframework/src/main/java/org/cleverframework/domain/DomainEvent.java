package org.cleverframework.domain;

import org.cleverframework.events.Event;

public abstract class DomainEvent extends Event {

    private String aggregateRootId;

    public DomainEvent(String aggregateRootId) {

        this.aggregateRootId = aggregateRootId;
    }
}
