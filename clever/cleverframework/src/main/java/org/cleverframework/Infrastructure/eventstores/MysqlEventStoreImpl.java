package org.cleverframework.infrastructure.eventstores;

/**
 * @@author xiqin.liu
 */
public class MysqlEventStoreImpl implements EventStore {


    @Override
    public void appendEventsToStream(EventStreamRecord eventStream) {


    }

    /**
     * 获取聚合根下面所有事件
     *
     * @param aggregateRootId
     * @return
     */
    public EventStream get(String aggregateRootId) {

        return null;
    }


    /**
     * 获取某个版本后面所有的事件
     *
     * @param aggregateRootId 聚合根ID
     * @param version         聚合版本号
     * @return
     */
    @Override
    public EventStream get(String aggregateRootId, int version) {

        return null;
    }
}
