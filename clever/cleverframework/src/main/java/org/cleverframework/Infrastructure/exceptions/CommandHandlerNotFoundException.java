package org.cleverframework.infrastructure.exceptions;

import org.cleverframework.commands.Command;

/**
 * 无法找到命令处理器异常
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/5 16:20
 */
public class CommandHandlerNotFoundException extends RuntimeException {

    public CommandHandlerNotFoundException(String commandName) {

        super(String.format("无法找到命令：%s 相关的处理器.", commandName));
    }
}
