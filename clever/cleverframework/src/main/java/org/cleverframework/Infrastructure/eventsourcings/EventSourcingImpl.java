package org.cleverframework.infrastructure.eventsourcings;

import org.cleverframework.infrastructure.eventstores.EventStore;
import org.cleverframework.infrastructure.eventstores.MysqlEventStoreImpl;
import org.cleverframework.infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.domain.AggregateRoot;

/**
 * 事件溯源
 *
 * @author xiqin.liu
 */
public class EventSourcingImpl implements EventSourcing {

    private EventStore eventStore = new MysqlEventStoreImpl();

    private SnapshotStorage snapshotStorage = new MysqlSnapshotStorage();

    public <T extends AggregateRoot> T get(String aggregateRootId) {

        return null;
    }
}
