package org.cleverframework.commands;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface CommandContext {

    void add(AggregateRoot aggregateRoot);

    <T extends AggregateRoot> T get(String aggregateRootId);
}
