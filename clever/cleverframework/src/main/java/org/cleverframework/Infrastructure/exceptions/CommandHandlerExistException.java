package org.cleverframework.infrastructure.exceptions;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 16:23
 */
public class CommandHandlerExistException extends RuntimeException {

    public CommandHandlerExistException(String commandName) {

        super(String.format("已经存在该命令：%s，对应的命令处理器.", commandName));
    }
}
