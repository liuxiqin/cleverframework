package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandContext;

public interface CommandHandler<TCommand extends Command> {

    void handle(CommandContext commandContext, TCommand command);
}
