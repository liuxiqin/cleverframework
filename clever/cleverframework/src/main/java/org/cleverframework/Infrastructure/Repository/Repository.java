package org.cleverframework.Infrastructure.Repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface Repository {

    <T extends AggregateRoot> void put(String aggregateRootId, T aggregateRoot);

    <T extends AggregateRoot> T get(String aggregateRootId);
}
