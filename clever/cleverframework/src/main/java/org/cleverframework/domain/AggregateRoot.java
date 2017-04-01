package org.cleverframework.domain;

import org.cleverframework.eventhandings.EventHandlerInvoker;
import org.cleverframework.eventhandings.EventHandlerProvider;
import org.cleverframework.events.Event;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public abstract class AggregateRoot implements Serializable {

    private static final long serialVersionUID = -4697010448972546861L;

    private EventHandlerProvider eventHandlerProvider;

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

        return null;
    }

    public void applyEvent(Event event) {

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
