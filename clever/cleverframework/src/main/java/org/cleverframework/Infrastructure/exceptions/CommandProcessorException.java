package org.cleverframework.infrastructure.exceptions;

/**
 * 命令处理异常
 *
 * @author xiqin.liu
 */
public class CommandProcessorException extends RuntimeException {

    public CommandProcessorException(String message) {
        super(message);
    }
}
