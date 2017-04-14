package org.cleverframework.Infrastructure.eventsourcings;

import org.cleverframework.domain.AggregateRoot;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface EventSourcing {

    <T extends AggregateRoot> T get(String aggregateRootId);

}
