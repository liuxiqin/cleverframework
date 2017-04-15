package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;

/**
 * Created by cass02 on 2017/4/15.
 */
public class CommandProcessorProxy implements CommandProcessor {

    private CommandProcessor commandProcessor;

    public CommandProcessorProxy(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public <T extends Command> void process(CommandHandlerInvoker invoker, T command) throws Exception {
        commandProcessor.process(invoker, command);
    }
}
