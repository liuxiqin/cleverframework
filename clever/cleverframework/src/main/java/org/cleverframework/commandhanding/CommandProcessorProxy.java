package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;

/**
 * 命令处理器代理类
 *
 * @author xiqin.liu
 */
public class CommandProcessorProxy implements CommandProcessor {

    private CommandProcessor commandProcessor;

    public CommandProcessorProxy(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    @Override
    public <T extends Command> void process(CommandProcessorContext context) {
        commandProcessor.process(context);
    }
}
