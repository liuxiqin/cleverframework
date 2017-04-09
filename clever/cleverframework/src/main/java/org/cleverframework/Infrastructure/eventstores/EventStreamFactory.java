package org.cleverframework.Infrastructure.eventstores;

import org.cleverframework.Infrastructure.serializes.BinarySerializer;
import org.cleverframework.Infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.events.Event;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class EventStreamFactory {


    public static BinarySerializer binarySerializer = new BinarySerializerImpl();

    public static EventStreamRecord create(AggregateRoot aggregateRoot, String commandId) throws Exception {


        EventStreamRecord eventStream = new EventStreamRecord();

        eventStream.setVersion(aggregateRoot.getVersion());
        eventStream.setAggregateRootId(aggregateRoot.getId());
        eventStream.setCommandId(commandId);
        eventStream.setEventBytes(binarySerializer.serialize(aggregateRoot.getUnCommitEvents()));

        return eventStream;
    }
}
