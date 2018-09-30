package org.cleverframework.messages;

import org.cleverframework.commands.Command;
import org.cleverframework.events.Event;
import org.cleverframework.infrastructure.serializes.JsonSerializer;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/30 17:23
 */
public class MessageBuilder {

    private JsonSerializer jsonSerializer;

    public MessageBuilder(JsonSerializer jsonSerializer) {

        this.jsonSerializer = jsonSerializer;
    }

    public MessageWrapper build(Event event, String topic) {

        throw new UnsupportedOperationException();
    }

    public MessageWrapper build(Command command, String topic, boolean needResponse) {

        throw new UnsupportedOperationException();
    }

    public MessageWrapper build(Message message) {

        throw new UnsupportedOperationException();
    }
}
