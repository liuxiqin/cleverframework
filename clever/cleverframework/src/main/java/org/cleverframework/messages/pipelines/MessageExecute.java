package org.cleverframework.messages.pipelines;

import org.cleverframework.messages.MessageExecuteContext;

/**
 * 消息执行抽象
 */
public interface MessageExecute {

    /**
     * 消息执行管道
     *
     * @param context
     */
    void execute(MessageExecuteContext context);
}
