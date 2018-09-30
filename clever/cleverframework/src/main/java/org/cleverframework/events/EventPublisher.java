package org.cleverframework.events;

import java.util.List;

/**
 * 事件发布接口抽象
 *
 * @author xiqin.liu
 */
public interface EventPublisher {

    /**
     * 批量事件发送
     *
     * @param events
     */
    void publish(List<Event> events);

    /**
     * 单个事件发布
     *
     * @param event
     */
    void publish(Event event);
}
