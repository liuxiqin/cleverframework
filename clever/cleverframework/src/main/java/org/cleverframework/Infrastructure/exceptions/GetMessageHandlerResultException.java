package org.cleverframework.infrastructure.exceptions;

/**
 * 获取消息处理结果异常
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 10:34
 */
public class GetMessageHandlerResultException extends RuntimeException {

    public GetMessageHandlerResultException(String messageId, Throwable e) {

        super("获取消息处理结果失败，MessageId：" + messageId, e);
    }
}
