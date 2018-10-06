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

            RemoteEndPoint remoteEndPoint = null;

            commandDispatcher.dispatch((Command) context.getMessage(), get(context.getMessageWrapper()), context.getMessageWrapper().getNeedResponse());
        }

        /**
         * 事件处理
         */
        if (context.getMessage() instanceof Event) {
            eventProcessor.execute(new EventProcessorContext((Event) context.getMessage()));
        }

        return null;
    }

    /**
     * 获取远程目标地址
     *
     * @param messageWrapper
     * @return
     */
    private RemoteEndPoint get(MessageWrapper messageWrapper) {

        return (RemoteEndPoint) messageWrapper.getAttributes().getOrDefault(RemoteEndPoint.RemoteEndPoint_KEY, null);

    }
}
