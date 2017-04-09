package org.cleverframework.commands;

import com.google.common.collect.Maps;
import org.cleverframework.Infrastructure.Repository.Repository;
import org.cleverframework.domain.AggregateRoot;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandContextImpl implements CommandContext {

    @Resource
    private Repository repository;

    private Map<String, AggregateRoot> aggregateRoots = Maps.newHashMap();


    public Map<String, AggregateRoot> getAggregateRoots() {
        return null;
    }

    public void add(AggregateRoot aggregateRoot) {


    }

    public <T extends AggregateRoot> T get(String aggregateRootId) {
        return null;
    }
}
