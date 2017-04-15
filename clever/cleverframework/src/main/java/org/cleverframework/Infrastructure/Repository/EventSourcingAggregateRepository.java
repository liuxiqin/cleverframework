package org.cleverframework.Infrastructure.Repository;

import org.cleverframework.Infrastructure.eventsourcings.AggregateRootMemoryCache;
import org.cleverframework.Infrastructure.eventsourcings.AggregateRootMemoryCacheImpl;
import org.cleverframework.Infrastructure.eventstores.EventStore;
import org.cleverframework.Infrastructure.eventstores.EventStream;
import org.cleverframework.Infrastructure.eventstores.MysqlEventStoreImpl;
import org.cleverframework.Infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.Infrastructure.snapshots.Snapshot;
import org.cleverframework.Infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.domain.AggregateRootFactory;

/**
 * Created by cass02 on 2017/4/15.
 */
public class EventSourcingAggregateRepository<T extends AggregateRoot> implements AggregateRepository<T> {

    private EventStore eventStore = new MysqlEventStoreImpl();

    private SnapshotStorage snapshotStorage = new MysqlSnapshotStorage();

    private AggregateRootMemoryCache memoryCache = new AggregateRootMemoryCacheImpl();

    public T get(String aggregateRootId) throws Exception {

        T aggregateRoot = memoryCache.get(aggregateRootId);

        if (aggregateRoot != null && aggregateRoot.getUnCommitEvents().size() == 0)
            return aggregateRoot;

        Snapshot snapshot = snapshotStorage.getLastSnapshot(aggregateRootId);

        if (snapshot != null)
            aggregateRoot = AggregateRootFactory.createNew(snapshot.getAggregateRootBytes());

        if (aggregateRoot == null)
            aggregateRoot = AggregateRootFactory.createNew();

        EventStream eventStream = eventStore.get(aggregateRootId, aggregateRoot.getVersion());

        if (eventStream != null && eventStream.getEvents() != null && eventStream.getEvents().size() > 0)
            aggregateRoot.applyEvents(eventStream.getEvents());

        memoryCache.put(aggregateRootId, aggregateRoot);

        return aggregateRoot;
    }

}
