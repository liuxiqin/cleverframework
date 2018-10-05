package org.cleverframework.messages;

import org.cleverframework.commandhanding.CommandDispatcher;
import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;
import org.cleverframework.eventhandings.EventProcessor;
import org.cleverframework.eventhandings.EventProcessorContext;
import org.cleverframework.events.Event;

/**
 * 消息分发器实现
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/5 15:05
 */
public class MessageDispatcherImpl implements MessageDispatcher {

    private CommandDispatcher commandDispatcher;

    private EventProcessor eventProcessor;

    public MessageDispatcherImpl(CommandDispatcher commandDispatcher, EventProcessor eventProcessor) {

        this.commandDispatcher = commandDispatcher;
        this.eventProcessor = eventProcessor;
    }


    @Override
    public MessageHandlerResult dispatch(MessageHandlerContext context) {

        //命令处理
        if (context.getMessage() instanceof Command) {

            commandDispatcher.dispatch((Command) context.getMessage());
        }

        /**
         * 事件处理
         */
        if (context.getMessage() instanceof Event) {
            eventProcessor.process(new EventProcessorContext((Event) context.getMessage()));
        }

        return null;

    }
}
