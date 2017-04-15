package org.cleverframework.commandhanding;

import java.util.HashMap;
import java.util.Map;

public class CommandHandlerProvider {

    private Map<String, CommandHandler<?>> commandHandlers = new HashMap<String, CommandHandler<?>>();

    public void put(String commandName, CommandHandler<?> commandHandler) throws Exception {

        if (commandHandlers.containsKey(commandName)) {
            throw new Exception("commandName has repeat.");
        }

        commandHandlers.put(commandName, commandHandler);
    }

    public CommandHandler<?> getHandler(String commandName) throws Exception {
        if (!commandHandlers.containsKey(commandName))
            throw new Exception("can not find the commandHandler when " + commandName);

        return commandHandlers.get(commandName);
    }

}
