package org.cleverframework.Infrastructure.eventsourcings;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by Administrator on 2017-04-14 .
 */
public interface AggregateRootMemoryCache {

    <T extends AggregateRoot> void put(String aggregateRootId, T aggregateRoot);

    <T extends AggregateRoot> T get(String aggregateRootId);
}
