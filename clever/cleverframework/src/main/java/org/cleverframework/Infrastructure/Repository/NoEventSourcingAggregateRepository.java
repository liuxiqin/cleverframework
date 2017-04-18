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
 * Created by cass02 on 2017/4/2.
 */
public class NoEventSourcingAggregateRepository<T extends AggregateRoot> implements AggregateRepository<T> {

    private GenericDao<T, String> genericDao = new GenericDaoImpl<T, String>();

    public T get(String aggregateRootId) throws Exception {
        return genericDao.get(aggregateRootId);
    }
}
