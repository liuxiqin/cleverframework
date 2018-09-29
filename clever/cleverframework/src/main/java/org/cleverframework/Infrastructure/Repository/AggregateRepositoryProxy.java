package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * 聚合资源库代理类
 */
public class AggregateRepositoryProxy<T extends AggregateRoot> implements AggregateRepository {

    private AggregateRepository<T> aggregateRepository;

    public AggregateRepositoryProxy(AggregateRepository<T> aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    public AggregateRoot get(String aggregateRootId) {
        return aggregateRepository.get(aggregateRootId);
    }

}
