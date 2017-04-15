package org.cleverframework.messages;

public interface MessageProducer {
    void send(MessageWrapper messageWrapper) throws Exception;
}
