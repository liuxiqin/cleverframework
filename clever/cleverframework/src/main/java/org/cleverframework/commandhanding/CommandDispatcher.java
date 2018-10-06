package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;
import org.cleverframework.messages.RemoteEndPoint;


/**
 * 命令分发器
 *
 * @author xiqin.liu
 */
public class CommandDispatcher {

    private CommandHandlerProvider commandHandlerProvider;

    private CommandProcessor commandProcessor;

    public CommandDispatcher(CommandHandlerProvider commandHandlerProvider,
                             CommandProcessor commandProcessor) {

        this.commandHandlerProvider = commandHandlerProvider;
        this.commandProcessor = commandProcessor;
    }

    public <T extends Command> void dispatch(T command, RemoteEndPoint endPoint, boolean needToReply) {

        CommandHandler commandHandler = commandHandlerProvider.getHandler(command.getClass().getName());

        CommandProcessorContext context = new CommandProcessorContext(commandHandler, command);

        context.setNeedToReply(needToReply);
        context.setRemoteEndPoint(endPoint);

        commandProcessor.execute(context);
    }
}
