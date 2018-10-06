package org.cleverframework.eventhandings;

import org.cleverframework.events.Event;

/**
 * 事件处理接口定义
 *
 * @param <TEvent>
 * @author xiqin.liu
 */
public interface EventHandler<TEvent extends Event> {

    /**
     * 事件处理方法
     *
     * @param event
     */
    void handle(TEvent event);
}
 
