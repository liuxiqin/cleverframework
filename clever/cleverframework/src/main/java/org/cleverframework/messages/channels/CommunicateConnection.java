package org.cleverframework.messages.channels;

/**
 * Created by Administrator on 2017-04-09 .
 */
public interface CommunicateConnection {

    CommunicateChannel createChannel();

    void open();

    void close();
}

