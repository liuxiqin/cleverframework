package org.cleverframework.commands;

import org.cleverframework.commandhanding.CommandHandler;
import org.cleverframework.messages.RemoteEndPoint;

/**
 * 命令处理上下文
 *
 * @param <T> T is the child class of Command.
 * @author xiqin.liu
 */
public class CommandProcessorContext<T extends Command> {

    /**
     * 命令处理器
     */
    private CommandHandler<T> commandHandler;

    /**
     * Command 命令
     */
    private Command command;

    /**
     * Command 处理结果
     */
    private CommandExecuteResult result;

    /**
     * Command处理结果应答目标地址
     */
    private RemoteEndPoint remoteEndPoint;

    /**
     * 是否需要应答Command处理结果
     */
    private boolean needToReply;

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

    public RemoteEndPoint getRemoteEndPoint() {
        return remoteEndPoint;
    }

    public void setRemoteEndPoint(RemoteEndPoint remoteEndPoint) {
        this.remoteEndPoint = remoteEndPoint;
    }

    public boolean isNeedToReply() {
        return needToReply;
    }

    public void setNeedToReply(boolean needToReply) {
        this.needToReply = needToReply;
    }
}
