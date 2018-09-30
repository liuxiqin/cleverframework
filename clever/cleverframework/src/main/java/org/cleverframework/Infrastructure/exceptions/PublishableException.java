package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.common.ObjectId;

import java.util.Date;

/**
 * 可发布的异常类抽象定义
 */
public abstract class PublishableException extends Throwable {

    public String id;

    private Date timeStamp;

    private String messageId;

    public PublishableException() {
        id = ObjectId.getNextId();
        timeStamp = new Date();
    }
}
