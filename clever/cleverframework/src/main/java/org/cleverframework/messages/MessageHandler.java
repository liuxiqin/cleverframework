package org.cleverframework.messages;

public interface MessageHandler<TMessage extends Message> {
    void handle(TMessage message);
}
