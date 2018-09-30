package org.cleverframework.events;

import org.cleverframework.messages.MessageProducer;

import java.util.List;

/**
 * 事件发布接口抽象.
 *
 * @author xiqin.liu
 */
public class EventPublisherImpl implements EventPublisher {

    private MessageProducer messageProducer;

    public EventPublisherImpl(MessageProducer messageProducer) {

        this.messageProducer = messageProducer;
    }

    @Override
    public void publish(List<Event> events) {

    }

    @Override
    public void publish(Event event) {

    }
}
