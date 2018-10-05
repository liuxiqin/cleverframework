package org.cleverframework.eventhandings;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 16:08
 */
public interface EventProcessor {

    void process(EventProcessorContext context);
}
