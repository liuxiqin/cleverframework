package org.cleverframework.eventhandings;

/**
 * @
 * @Author: xiqin.liu
 * @Date: 2018/10/6 16:42
 */
public class EventProcessorImpl implements EventProcessor {

    private EventHandlerProvider eventHandlerProvider;

    public EventProcessorImpl(EventHandlerProvider eventHandlerProvider) {

        this.eventHandlerProvider = eventHandlerProvider;
    }

    @Override
    public void execute(EventProcessorContext context) {

        EventHandler eventHandler = eventHandlerProvider.getEventHandler(context.getEvent().getClass());

        context.setEventHandler(eventHandler);

        eventHandler.handle(context.getEvent());
    }
}
