package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandDispatcher {

    @Resource
    private CommandHandlerProvider commandHandlerProvider;

    @Resource
    private CommandProcessor commandProcessor = new CommandProcessorProxy(new CommandProcessorImpl());

    public <T extends Command> void dispatch(T command) throws Exception {

        CommandHandler commandHandler = commandHandlerProvider.getHandler(command.getClass().getName());

        CommandProcessorContext context = new  CommandProcessorContext(commandHandler, command);

        commandProcessor.process(context);
    }
}
