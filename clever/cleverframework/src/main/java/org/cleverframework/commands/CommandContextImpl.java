package org.cleverframework.commands;

import org.cleverframework.Infrastructure.Repository.AggregateRepositoryProxy;
import org.cleverframework.Infrastructure.Repository.EventSourcingAggregateRepository;
import org.cleverframework.Infrastructure.Repository.NoEventSourcingAggregateRepository;
import org.cleverframework.Infrastructure.Repository.AggregateRepository;
import org.cleverframework.domain.AggregateRoot;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandContextImpl implements CommandContext {

    private Map<String, AggregateRoot> aggregateRoots = new HashMap();

    public Map<String, AggregateRoot> getAggregateRoots() {

        return aggregateRoots;
    }

    public void add(AggregateRoot aggregateRoot) {
        aggregateRoots.put(aggregateRoot.getId(), aggregateRoot);
    }

    public <T extends AggregateRoot> T get(String aggregateRootId) throws Exception {

        AggregateRepository<T> repository = new AggregateRepositoryProxy<T>(new EventSourcingAggregateRepository<T>());

        if (!aggregateRoots.containsKey(aggregateRootId)) {

            T aggregateRoot = repository.get(aggregateRootId);

            aggregateRoots.put(aggregateRootId, aggregateRoot);
        }

        return (T) aggregateRoots.get(aggregateRootId);
    }
}
