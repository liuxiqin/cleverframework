package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface AggregateRepository<T extends AggregateRoot> {

    T get(String aggregateRootId);
}
