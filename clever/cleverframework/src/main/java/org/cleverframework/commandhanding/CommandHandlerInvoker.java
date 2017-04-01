package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017-04-01 .
 */
public class CommandHandlerInvoker {

    private final Method method;

    private final String commandName;

    private final CommandHandler commandHandler;

    public CommandHandlerInvoker(Method method, String commandName, CommandHandler commandHandler) {

        this.method = method;
        this.commandName = commandName;
        this.commandHandler = commandHandler;
    }

    public void invoke(Command command) throws InvocationTargetException, IllegalAccessException {
        method.invoke(commandHandler, command);
    }

    public void invoke(Object handle, Command command) throws InvocationTargetException, IllegalAccessException {
        method.invoke(handle, command);
    }
}
