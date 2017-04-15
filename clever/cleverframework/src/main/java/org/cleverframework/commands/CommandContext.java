package org.cleverframework.commands;

import org.cleverframework.domain.AggregateRoot;

import java.util.Map;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface CommandContext {

    Map<String, AggregateRoot> getAggregateRoots();

    <T extends AggregateRoot> void add(AggregateRoot aggregateRoot);

    <T extends AggregateRoot> T get(String aggregateRootId) throws  Exception;
}
