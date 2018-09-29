package org.cleverframework.infrastructure.eventsourcings;

import org.cleverframework.domain.AggregateRoot;

/**
 * 事件溯源接口抽象
 *
 * @author xiqin.liu
 */
public interface EventSourcing {

    <T extends AggregateRoot> T get(String aggregateRootId);

}
