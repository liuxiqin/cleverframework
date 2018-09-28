package org.cleverframework.infrastructure.eventstores;

/**
 * 事件存储接口抽象
 */
public interface EventStore {

    /**
     * 追加事件流
     *
     * @param eventStream 事件流记录
     */
    void appendEventsToStream(EventStreamRecord eventStream);

    /**
     * 获取事件流
     *
     * @param aggregateRootId 聚合根ID
     * @param version         聚合版本号
     * @return 事件流
     */
    EventStream get(String aggregateRootId, int version);
}

