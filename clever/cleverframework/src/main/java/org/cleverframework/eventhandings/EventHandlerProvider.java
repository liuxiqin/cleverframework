package org.cleverframework.eventhandings;

import org.cleverframework.infrastructure.exceptions.EventHandlerNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * 事件处理器提供者
 * the contains of EventHandlers
 *
 * @@author xiqin.liu
 */
public interface EventHandlerProvider {

    /**
     * 获取事件对应的事件处理器
     *
     * @param eventClass Event Class
     * @return
     */
    EventHandler getEventHandler(Class<?> eventClass);

    /**
     * 获取事件对应的事件处理器
     *
     * @param eventName Event 类名全称
     * @return
     */
    EventHandler<?> getEventHandler(String eventName);


}
