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

    private CommandExecuteResult result;

    public CommandProcessorContext(CommandHandler<T> commandHandler, Command command) {

        this.commandHandler = commandHandler;
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public CommandHandler<T> getCommandHandler() {
        return commandHandler;
    }

    public void setCommandHandler(CommandHandler<T> commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public CommandExecuteResult getResult() {
        return result;
    }

    public void setResult(CommandExecuteResult result) {
        this.result = result;
    }
}
