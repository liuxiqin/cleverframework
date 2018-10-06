package org.cleverframework.eventhandings;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 16:08
 */
public interface EventProcessor {

    /**
     * 事件调度处理
     *
     * @param context
     */
    void execute(EventProcessorContext context);
}
