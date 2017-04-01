package org.cleverframework.commands;

import org.cleverframework.messages.Message;

public abstract class Command extends Message {

    private String commandId;

    public Command(String uniqueId) {
        super(uniqueId);
        commandId = uniqueId;
    }

    public String getCommandId() {
        return this.commandId;
    }

}
