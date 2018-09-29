package org.cleverframework.messages.channels;

import com.rabbitmq.client.Channel;

/**
 * Created by Administrator on 2017-04-16 .
 */
public class MessageChannel {

    private Channel channel;

    public MessageChannel(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return this.channel;
    }
}
