package org.cleverframework.messages.channels;

import org.cleverframework.messages.MessageHandlerResult;
import org.cleverframework.messages.RemoteEndPoint;

/**
 * Command 处理结果应答通道
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/6 15:25
 */
public interface MessageResultSendChannel {


    /**
     * Command 处理结果应答
     *
     * @param result
     * @param endPoint
     */
    void send(MessageHandlerResult result, RemoteEndPoint endPoint);

}
