package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.messages.MessageResultContext;

/**
 * 发送消息处理结果到目标机器上
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 13:22
 */
public class SendMessageHandlerResultException extends RuntimeException {

    public SendMessageHandlerResultException(MessageResultContext context) {

        super("发送消息处理结果到目标地址失败, 目标地址数据:" + context.toString());
    }
}
