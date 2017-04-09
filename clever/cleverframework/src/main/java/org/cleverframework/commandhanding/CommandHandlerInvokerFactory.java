package org.cleverframework.commandhanding;


import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017-04-01 .
 */
public class CommandHandlerInvokerFactory {

    public static CommandHandlerInvoker create(String commandName, CommandHandler commandHandler) {

        return new CommandHandlerInvoker(commandName, commandHandler);

    }
}
