package org.cleverframework.Infrastructure.eventsourcings;

import org.cleverframework.Infrastructure.eventstores.EventStore;
import org.cleverframework.Infrastructure.eventstores.EventStream;
import org.cleverframework.Infrastructure.eventstores.MysqlEventStoreImpl;
import org.cleverframework.Infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.Infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public class EventSourcingImpl implements EventSourcing {

    private EventStore eventStore = new MysqlEventStoreImpl();

    private SnapshotStorage snapshotStorage = new MysqlSnapshotStorage();

    public <T extends AggregateRoot> T get(String aggregateRootId) {


        return null;
    }
}
