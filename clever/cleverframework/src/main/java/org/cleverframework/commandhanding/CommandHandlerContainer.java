package org.cleverframework.commandhanding;

import com.google.common.collect.Maps;
import org.cleverframework.commands.Command;

import java.util.Map;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandHandlerContainer {

    private Map<String, CommandHandlerInvoker> handlerMaps;

    public CommandHandlerContainer() {
        handlerMaps = Maps.newHashMap();
    }

    public void add(String commandName, CommandHandlerInvoker commandHandlerInvoker) throws Exception {

        if (handlerMaps.containsKey(commandName)) {
            throw new Exception("CommandHandlerContainer had container the key" + commandName);
        }

        handlerMaps.put(commandName, commandHandlerInvoker);
    }

    public CommandHandlerInvoker get(String commandName) throws Exception {
        if (!handlerMaps.containsKey(commandName))
            throw new Exception("CommandHandlerContainer not container the key" + commandName);

        return handlerMaps.get(commandName);
    }

    public <T extends Command> CommandHandlerInvoker get(T command) throws Exception {

        String commandName = command.getClass().getName();

        return this.get(commandName);

    }
}
