package org.cleverframework.infrastructure.eventsourcings;

import org.cleverframework.domain.AggregateRoot;

/**
 * 聚合根缓存接口抽象
 *
 * @author xiqin.liu
 */
public interface AggregateRootMemoryCache {

    <T extends AggregateRoot> void put(String aggregateRootId, T aggregateRoot);

    <T extends AggregateRoot> T get(String aggregateRootId);
}
