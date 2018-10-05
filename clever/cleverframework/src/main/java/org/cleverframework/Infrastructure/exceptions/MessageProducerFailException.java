package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.messages.MessageWrapper;

public class MessageProducerFailException extends RuntimeException {

    private static final long serialVersionUID = -6703345482199291797L;

    public MessageProducerFailException(MessageWrapper messageWrapper, Throwable throwable) {
        super("message producer fail, message:" + messageWrapper.toString(), throwable);

    }
}
