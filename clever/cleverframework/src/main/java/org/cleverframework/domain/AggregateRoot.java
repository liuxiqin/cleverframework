package org.cleverframework.domain;

import org.cleverframework.eventhandings.*;
import org.cleverframework.events.Event;
import org.cleverframework.messages.MessageProducer;

import java.io.Serializable;
import java.util.*;


public abstract class AggregateRoot implements Serializable {

    private static final long serialVersionUID = -4697010448972546861L;

    private EventHandlerProvider eventHandlerProvider;

    private MessageProducer messageProducer;

    private final String aggregateRootId;

    private int version;

    private Queue<Event> unCommitEvents;

    public AggregateRoot(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
        unCommitEvents = new LinkedList<Event>();
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public String getId() {
        return aggregateRootId;
    }

    public List<Event> getUnCommitEvents() {

        List<Event> events = new ArrayList<Event>();

        for (Event event : unCommitEvents)
            events.add(event);

        return events;
    }

    public void applyEvent(Event event) {
        if (event instanceof DomainEvent)
            handleEvent(event);
        appendUnCommitEvents(event);
    }

    public void appendUnCommitEvents(Event event) {

        if (unCommitEvents == null)
            unCommitEvents = new LinkedList<Event>();

        unCommitEvents.add(event);
    }

    public void applyEvents(List<Event> events) {
        for (Event event : events) {
            applyEvent(event);
        }
    }

    public void handleEvent(Event event) {

        if (eventHandlerProvider == null) {
            eventHandlerProvider = new EventHandlerProvider();
        }

        try {
            EventHandlerInvoker handler = eventHandlerProvider.getEventInvoker(event.getClass().getName());
            if (handler == null)
                return;
            handler.invoke(this, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        unCommitEvents.clear();
    }
}
