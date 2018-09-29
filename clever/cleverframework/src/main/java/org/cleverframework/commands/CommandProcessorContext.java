package org.cleverframework.commands;

import org.cleverframework.commandhanding.CommandHandler;

/**
 * 命令处理上下文
 *
 * @param <T> T is the child class of Command.
 * @author xiqin.liu
 */
public class CommandProcessorContext<T extends Command> {

    private CommandHandler<T> commandHandler;

    private Command command;

    public CommandProcessorContext(CommandHandler<T> commandHandler, Command command) {

        this.commandHandler = commandHandler;
        this.command = command;
    }

    public CommandHandler<T> getCommandHandler() {
        return commandHandler;
    }

    public Command getCommand() {
        return command;
    }
}
