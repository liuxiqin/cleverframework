package org.cleverframework.messages;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 14:43
 */
public interface MessageDispatcher {

    /**
     * 消息分发
     *
     * @param context
     * @return
     */
    MessageHandlerResult dispatch(MessageHandlerContext context);
}
