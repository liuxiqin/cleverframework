package org.cleverframework.infrastructure.eventsourcings;

import org.cleverframework.domain.AggregateRoot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地进程内存的聚合根缓存
 *
 * @author xiqin.liu
 */
public class AggregateRootMemoryCacheImpl implements AggregateRootMemoryCache {

    private Map<String, AggregateRoot> aggregateRootCaches;

    public AggregateRootMemoryCacheImpl() {

        aggregateRootCaches = new ConcurrentHashMap<String, AggregateRoot>();
    }

    public void put(String aggregateRootId, AggregateRoot aggregateRoot) {

        aggregateRootCaches.put(aggregateRootId, aggregateRoot);
    }

    public AggregateRoot get(String aggregateRootId) {

        if (!aggregateRootCaches.containsKey(aggregateRootId)) {
            return null;
        }
        return aggregateRootCaches.get(aggregateRootId);
    }
}
