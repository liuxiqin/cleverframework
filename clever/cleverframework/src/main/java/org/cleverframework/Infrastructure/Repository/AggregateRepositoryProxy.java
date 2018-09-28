package org.cleverframework.infrastructure.repository;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/15.
 */
public class AggregateRepositoryProxy<T extends AggregateRoot> implements AggregateRepository {

    private AggregateRepository<T> aggregateRepository;

    public AggregateRepositoryProxy(AggregateRepository<T> aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    public AggregateRoot get(String aggregateRootId) throws Exception {
        return aggregateRepository.get(aggregateRootId);
    }
}
