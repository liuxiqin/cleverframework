package org.cleverframework.commandhanding;

import org.cleverframework.infrastructure.exceptions.CommandHandlerExistException;
import org.cleverframework.infrastructure.exceptions.CommandHandlerNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * 命令处理器
 *
 * @author xiqin.liu
 */
public class CommandHandlerProvider {

    private Map<String, CommandHandler<?>> commandHandlers = new HashMap<>();

    public void put(String commandName, CommandHandler<?> commandHandler) {

        if (commandHandlers.containsKey(commandName)) {
            throw new CommandHandlerExistException("commandName has repeat.");
        }

        commandHandlers.put(commandName, commandHandler);
    }

    public CommandHandler<?> getHandler(String commandName)  {

        if (!commandHandlers.containsKey(commandName)) {
            throw new CommandHandlerNotFoundException(commandName);
        }

        return commandHandlers.get(commandName);
    }

}
