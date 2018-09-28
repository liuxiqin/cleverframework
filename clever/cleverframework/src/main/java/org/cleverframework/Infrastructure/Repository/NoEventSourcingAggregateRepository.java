package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public class NoEventSourcingAggregateRepository<T extends AggregateRoot> implements AggregateRepository<T> {

    public T get(String aggregateRootId) throws Exception {
        return null;
    }


}
