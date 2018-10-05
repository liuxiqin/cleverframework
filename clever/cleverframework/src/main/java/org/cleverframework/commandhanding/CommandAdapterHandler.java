package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;

import java.lang.reflect.Method;

/**
 * 命令处理适配
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/5 15:48
 */
public class CommandAdapterHandler implements CommandHandler {

    private Object object;

    private CommandContext commandContext;

    private Method method;

    @Override
    public void handle(CommandContext commandContext, Command command) {

    }
}
