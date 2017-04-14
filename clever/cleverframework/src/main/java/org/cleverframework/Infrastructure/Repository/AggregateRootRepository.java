package org.cleverframework.Infrastructure.Repository;

import com.google.common.collect.Maps;
import org.cleverframework.Infrastructure.eventsourcings.AggregateRootMemoryCache;
import org.cleverframework.Infrastructure.eventsourcings.AggregateRootMemoryCacheImpl;
import org.cleverframework.Infrastructure.eventstores.EventStore;
import org.cleverframework.Infrastructure.eventstores.MysqlEventStoreImpl;
import org.cleverframework.Infrastructure.snapshots.MysqlSnapshotStorage;
import org.cleverframework.Infrastructure.snapshots.SnapshotStorage;
import org.cleverframework.domain.AggregateRoot;

import java.util.Map;

/**
 * Created by cass02 on 2017/4/2.
 */
public class AggregateRootRepository implements Repository {

//    private  ObjectInstantiator objectInstantiator;
//
//    public AggregateRootRepository(){
//
//        Objenesis objenesis = new ObjenesisStd();
//
//        ObjectInstantiator thingInstantiator = objenesis.getInstantiatorOf(AggregateRoot.class);
//    }

    private Map<String, AggregateRoot> aggregateRoots;

    private EventStore eventStore = new MysqlEventStoreImpl();

    private SnapshotStorage snapshotStorage = new MysqlSnapshotStorage();

    private AggregateRootMemoryCache memoryCache = new AggregateRootMemoryCacheImpl();

    public AggregateRootRepository() {
        aggregateRoots = Maps.newConcurrentMap();
    }

    public <T extends AggregateRoot> void put(String aggregateRootId, T aggregateRoot) {

        aggregateRoots.put(aggregateRootId, aggregateRoot);
    }

    public <T extends AggregateRoot> T get(String aggregateRootId) {

        if (!aggregateRoots.containsKey(aggregateRootId))
            return null;



        AggregateRoot aggregateRoot = aggregateRoots.get(aggregateRootId);

        if (aggregateRoot.getUnCommitEvents().size() > 0) {

        }
        return (T) aggregateRoots.get(aggregateRootId);
    }

//    private AggregateRoot createNew(){
//
//
//       return (AggregateRoot)thingInstantiator.newInstance();
//    }
}
