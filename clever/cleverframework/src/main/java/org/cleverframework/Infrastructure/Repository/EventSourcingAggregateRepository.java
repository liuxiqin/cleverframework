package org.cleverframework.infrastructure.repository;

import org.cleverframework.infrastructure.eventsourcings.AggregateRootMemoryCache;
import org.cleverframework.infrastructure.eventsourcings.AggregateRootMemoryCacheImpl;
import org.cleverframework.infrastructure.eventstores.EventStore;
import org.cleverframework.infrastructure.eventstores.EventStream;
import org.cleverframework.infrastructure.eventstores.MysqlEventStoreImpl;
import org.cleverframework.infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.infrastructure.snapshots.Snapshot;
import org.cleverframework.infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.domain.AggregateRootFactory;

/**
 * 事件溯源聚合根资源库实现
 */
public class EventSourcingAggregateRepository<T extends AggregateRoot> implements AggregateRepository<T> {

    private EventStore eventStore = new MysqlEventStoreImpl();

    private SnapshotStorage snapshotStorage = new MysqlSnapshotStorage();

    private AggregateRootMemoryCache memoryCache = new AggregateRootMemoryCacheImpl();

    public T get(String aggregateRootId) {

        T aggregateRoot = memoryCache.get(aggregateRootId);

        if (aggregateRoot != null && aggregateRoot.getUnCommitEvents().size() == 0) {
            return aggregateRoot;
        }

        Snapshot snapshot = snapshotStorage.getLastSnapshot(aggregateRootId);

        if (snapshot != null) {
            aggregateRoot = AggregateRootFactory.createNew(snapshot.getAggregateRootBytes());
        }
        if (aggregateRoot == null) {
            aggregateRoot = AggregateRootFactory.createNew();
        }

        EventStream eventStream = eventStore.get(aggregateRootId, aggregateRoot.getVersion());

        if (eventStream != null && eventStream.getEvents() != null && eventStream.getEvents().size() > 0) {
            aggregateRoot.applyEvents(eventStream.getEvents());
        }

        memoryCache.put(aggregateRootId, aggregateRoot);

        return aggregateRoot;
    }

}
