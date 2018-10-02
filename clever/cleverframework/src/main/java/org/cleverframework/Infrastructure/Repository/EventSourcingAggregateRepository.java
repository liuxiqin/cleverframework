package org.cleverframework.infrastructure.repository;

import org.cleverframework.infrastructure.eventsourcings.AggregateRootMemoryCache;
import org.cleverframework.infrastructure.eventstores.EventStore;
import org.cleverframework.infrastructure.eventstores.EventStream;
import org.cleverframework.infrastructure.snapshots.Snapshot;
import org.cleverframework.infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.domain.AggregateRootFactory;

/**
 * 事件溯源聚合根资源库实现
 *
 * @author xiqin.liu
 */
public class EventSourcingAggregateRepository implements AggregateRepository {

    private EventStore eventStore;

    private SnapshotStorage snapshotStorage;

    private AggregateRootMemoryCache memoryCache;

    public EventSourcingAggregateRepository(EventStore eventStore, SnapshotStorage snapshotStorage, AggregateRootMemoryCache memoryCache) {

        this.eventStore = eventStore;
        this.snapshotStorage = snapshotStorage;
        this.memoryCache = memoryCache;
    }


    @Override
    public <T extends AggregateRoot> T get(String aggregateRootId) {

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

    @Override
    public <T extends AggregateRoot> void save(T aggregateRoot) {

    }

}
