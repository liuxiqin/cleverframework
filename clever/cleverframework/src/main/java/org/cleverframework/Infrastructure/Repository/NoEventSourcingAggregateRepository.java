package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public class NoEventSourcingAggregateRepository<T extends AggregateRoot> implements AggregateRepository<T> {

    private GenericDao<T, String> genericDao = new GenericDaoImpl<T, String>();

    public T get(String aggregateRootId) throws Exception {
        return genericDao.get(aggregateRootId);
    }
}
