package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.common.ObjectId;

import java.util.Date;

public abstract class PublishableException extends RuntimeException {

    public String id;

    private Date timeStamp;

    public PublishableException() {
        id = ObjectId.getNextId();
        timeStamp = new Date();
    }
}
