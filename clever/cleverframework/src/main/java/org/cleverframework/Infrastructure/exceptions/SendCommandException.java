package org.cleverframework.infrastructure.exceptions;


import org.cleverframework.commands.Command;

/**
 * 命令发送失败异常
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/2 17:01
 */
public class SendCommandException extends RuntimeException {

    public SendCommandException(Command command) {

        super("发送命令失败,command data:" + command.toString());
    }
}