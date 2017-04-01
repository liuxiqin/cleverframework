package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;

public interface CommandHandler<TCommand extends Command> {

    void handle(TCommand command);
}
