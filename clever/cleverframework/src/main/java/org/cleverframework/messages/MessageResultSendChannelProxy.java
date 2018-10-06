package org.cleverframework.messages;

import org.cleverframework.messages.channels.MessageResultSendChannel;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/6 15:47
 */
public class MessageResultSendChannelProxy implements MessageResultSendChannel {

    private MessageResultSendChannel messageResultSendChannel;

    public MessageResultSendChannelProxy(MessageResultSendChannel messageResultSendChannel) {

        this.messageResultSendChannel = messageResultSendChannel;
    }


    @Override
    public void send(MessageHandlerResult result, RemoteEndPoint endPoint) {

    }
}
