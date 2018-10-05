package org.cleverframework.infrastructure.eventstores;

import com.google.common.collect.Lists;
import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.events.Event;
import org.cleverframework.messages.MessageConverter;

import java.util.List;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class EventStreamFactory {


    public static MessageConverter messageConverter;

    public static EventStreamRecord create(AggregateRoot aggregateRoot, String commandId) {


        EventStreamRecord eventStream = new EventStreamRecord();

        eventStream.setVersion(aggregateRoot.getVersion());
        eventStream.setAggregateRootId(aggregateRoot.getId());
        eventStream.setCommandId(commandId);
        eventStream.setEventBytes(messageConverter.toBytes(aggregateRoot.getUnCommitEvents()));

        return eventStream;
    }

    public static EventStream create(List<EventStreamRecord> records) {

        if (records == null || records.size() == 0) {
            return null;
        }

        try {
            EventStream eventStream = new EventStream();

            List<Event> events = Lists.newArrayList();

            for (EventStreamRecord record : records) {
                eventStream.setAggregateRootId(record.getAggregateRootId());
                eventStream.setVersion(record.getVersion());

                //TODO:
                List<Event> recordEvents = messageConverter.toObject(record.getEventBytes(), null);

                events.addAll(recordEvents);
            }
            eventStream.setEvents(events);

            return eventStream;
        } catch (Exception e) {
            return null;
        }
    }
}
