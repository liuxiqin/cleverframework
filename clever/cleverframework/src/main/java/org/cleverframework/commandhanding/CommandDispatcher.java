package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class CommandDispatcher {

    @Resource
    private CommandHandlerContainer handlerContainer;

    @Resource
    private CommandProcessor commandProcessor;

    public <T extends Command> void dispatch(T command) throws Exception {

        CommandHandlerInvoker commandHandlerInvoker = handlerContainer.get(command);

        commandProcessor.process(commandHandlerInvoker, command);
    }
}
