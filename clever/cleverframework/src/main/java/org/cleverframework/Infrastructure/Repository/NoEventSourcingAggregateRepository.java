package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * 非事件溯源资源库实现
 */
public class NoEventSourcingAggregateRepository<T extends AggregateRoot> implements AggregateRepository<T> {

    private GenericDao<T, String> genericDao = new GenericDaoImpl<T, String>();

    public T get(String aggregateRootId) {
        return genericDao.get(aggregateRootId);
    }
}
