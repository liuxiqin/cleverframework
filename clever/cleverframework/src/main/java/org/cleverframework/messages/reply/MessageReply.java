package org.cleverframework.messages.reply;

import org.cleverframework.messages.MessageHandlerResult;

/**
 * 消息应答抽象类
 *
 * @author xiqin.liu
 */
public interface MessageReply {

    /**
     * 获取应答结果, 此处可能会阻塞等待结果
     *
     * @return
     */
    MessageHandlerResult getResult();

    /**
     * 设置应答结果， 系统获取到消息结果进行赋值，并通知阻塞现线程
     *
     * @param result
     */
    void setResult(MessageHandlerResult result);
}
