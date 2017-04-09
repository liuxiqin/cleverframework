package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017-04-01 .
 */
public class CommandHandlerInvoker {

    private final String commandName;

    private final CommandHandler commandHandler;

    public CommandHandlerInvoker(String commandName, CommandHandler commandHandler) {

        this.commandName = commandName;
        this.commandHandler = commandHandler;
    }

    public void handle(CommandContext commandContext, Command command) throws InvocationTargetException, IllegalAccessException {
        commandHandler.handle(commandContext, command);
    }

}
