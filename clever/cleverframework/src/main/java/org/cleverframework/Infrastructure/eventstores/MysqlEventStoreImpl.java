package org.cleverframework.Infrastructure.eventstores;

import java.util.List;

/**
 * Created by cass02 on 2017/4/2.
 */
public class MysqlEventStoreImpl implements EventStore {

    public void AppendEventsToStream(EventStream eventStream) {


    }

    //获取聚合根下面所有事件
    public EventStream get(String aggregateRootId) {

        return null;
    }
    //获取某个版本后面所有的事件
    public EventStream get(String aggregateRootId, int version) {

        return null;
    }
}
