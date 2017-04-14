package org.cleverframework.commands;

import com.google.common.collect.Maps;
import org.cleverframework.Infrastructure.Repository.AggregateRootRepository;
import org.cleverframework.Infrastructure.Repository.Repository;
import org.cleverframework.domain.AggregateRoot;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandContextImpl implements CommandContext {

    @Resource
    private Repository repository = new AggregateRootRepository();

    private Map<String, AggregateRoot> aggregateRoots = new HashMap();

    public Map<String, AggregateRoot> getAggregateRoots() {

        return aggregateRoots;
    }

    public void add(AggregateRoot aggregateRoot) {
        aggregateRoots.put(aggregateRoot.getId(), aggregateRoot);
    }

    public <T extends AggregateRoot> T get(String aggregateRootId) {

        if (!aggregateRoots.containsKey(aggregateRootId)) {

            AggregateRoot aggregateRoot = repository.get(aggregateRootId);

            aggregateRoots.put(aggregateRootId, aggregateRoot);
        }

        return (T) aggregateRoots.get(aggregateRootId);
    }
}
