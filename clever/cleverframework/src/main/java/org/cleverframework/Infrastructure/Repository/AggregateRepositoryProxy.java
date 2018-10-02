package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * 聚合资源库代理类
 *
 * @author xiqin.liu
 */
public class AggregateRepositoryProxy implements AggregateRepository {

    private AggregateRepository aggregateRepository;

    public AggregateRepositoryProxy(AggregateRepository aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    @Override
    public <T extends AggregateRoot> T get(String aggregateRootId) {
        return aggregateRepository.get(aggregateRootId);
    }

    @Override
    public <T extends AggregateRoot> void save(T aggregateRoot) {

        throw new UnsupportedOperationException();
    }
}
