package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.messages.MessageHandlerResult;
import org.cleverframework.messages.RemoteEndPoint;

/**
 * 发送消息处理结果到目标机器上
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 13:22
 */
public class SendMessageHandlerResultException extends RuntimeException {

    public SendMessageHandlerResultException(MessageHandlerResult context, RemoteEndPoint endPoint) {
        super("发送消息处理结果到目标地址失败, 目标地址数据:" + context.toString());
    }
}
