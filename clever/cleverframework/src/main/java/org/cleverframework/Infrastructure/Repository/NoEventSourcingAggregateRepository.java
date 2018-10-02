package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * 非事件溯源资源库实现
 *
 * @author xiqin.liu
 */
public class NoEventSourcingAggregateRepository implements AggregateRepository {

    private GenericDao genericDao;

    public NoEventSourcingAggregateRepository(GenericDao genericDao) {

        this.genericDao = genericDao;
    }

    @Override
    public <T extends AggregateRoot> T get(String aggregateRootId) {

        return genericDao.get(aggregateRootId);
    }

    @Override
    public <T extends AggregateRoot> void save(T aggregateRoot) {

    }
}
