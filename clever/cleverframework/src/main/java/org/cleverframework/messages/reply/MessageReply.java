package org.cleverframework.messages.reply;

import org.cleverframework.messages.MessageHandlerResult;

/**
 * 消息应答抽象类
 *
 * @author xiqin.liu
 */
public interface MessageReply {

    /**
     * 获取应答结果
     *
     * @return
     */
    MessageHandlerResult getResult();

    /**
     * 设置应答结果
     *
     * @param result
     */
    void setResult(MessageHandlerResult result);
}
