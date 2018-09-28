package org.cleverframework.domain;

import org.cleverframework.context.ApplicationContext;
import org.cleverframework.eventhandings.*;
import org.cleverframework.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;


public class AggregateRoot implements Serializable {

    private static final long serialVersionUID = -4697010448972546861L;

    protected transient final Logger logger = LoggerFactory.getLogger(AggregateRoot.class);

    private transient EventHandlerProvider eventHandlerProvider;

    private String aggregateRootId;

    private int version = 0;

    private transient Queue<Event> unCommitEvents;

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

        if (eventHandlerProvider == null)
            eventHandlerProvider = ApplicationContext.getBean(EventHandlerProvider.class);

        try {
            EventHandler handler = eventHandlerProvider.getEventHandler(event.getClass().getName());
            if (handler == null)
                return;
            handler.handle(event);
        } catch (Exception e) {
            logger.error(" handleEvent error:->{}", event);
        }
    }

    public void clear() {
        unCommitEvents.clear();
    }
}
