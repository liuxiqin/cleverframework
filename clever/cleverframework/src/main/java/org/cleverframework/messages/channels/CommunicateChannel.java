package org.cleverframework.messages.channels;

import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.SendMessage;

/**
 * Created by Administrator on 2017-04-09 .
 */
public interface CommunicateChannel {

    void publish(SendMessage message);

    void close();
}
