package org.cleverframework.commands;

import org.cleverframework.infrastructure.repository.AggregateRepositoryProxy;
import org.cleverframework.infrastructure.repository.EventSourcingAggregateRepository;
import org.cleverframework.infrastructure.repository.AggregateRepository;
import org.cleverframework.domain.AggregateRoot;

import java.util.HashMap;
import java.util.Map;

/**
 * Command 上下文处理(获取聚合根, 添加聚合根)
 *
 * @author xiqin.liu
 */
public class CommandContextImpl implements CommandContext {

    private Map<String, AggregateRoot> aggregateRoots = new HashMap();

    public Map<String, AggregateRoot> getAggregateRoots() {

        return aggregateRoots;
    }

    public void add(AggregateRoot aggregateRoot) {

        aggregateRoots.put(aggregateRoot.getId(), aggregateRoot);
    }

    public <T extends AggregateRoot> T get(String aggregateRootId) {

        AggregateRepository<T> repository = new AggregateRepositoryProxy<T>(new EventSourcingAggregateRepository<T>());

        if (!aggregateRoots.containsKey(aggregateRootId)) {

            T aggregateRoot = repository.get(aggregateRootId);

            aggregateRoots.put(aggregateRootId, aggregateRoot);
        }

        return (T) aggregateRoots.get(aggregateRootId);
    }
}
