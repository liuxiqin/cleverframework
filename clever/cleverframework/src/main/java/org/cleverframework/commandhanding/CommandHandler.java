package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;

/**
 * 命令处理器抽象
 *
 * @param <TCommand>
 */
public interface CommandHandler<TCommand extends Command> {

    /**
     * 处理方法
     *
     * @param commandContext
     * @param command
     */
    void handle(CommandContext commandContext, TCommand command);
}
