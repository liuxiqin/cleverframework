package org.cleverframework.commands;

import org.cleverframework.messages.MessageHandlerResult;

/**
 * Created by cass02 on 2017/4/2.
 */
public class CommandExecuteResult {

    private String message;

    private CommandExecutedStatus commandExecutedStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommandExecutedStatus getCommandExecutedStatus() {
        return commandExecutedStatus;
    }

    public void setCommandExecutedStatus(CommandExecutedStatus commandExecutedStatus) {
        this.commandExecutedStatus = commandExecutedStatus;
    }

    public CommandExecuteResult(CommandExecutedStatus commandExecutedStatus) {
        this.commandExecutedStatus = commandExecutedStatus;
    }

    public CommandExecuteResult(CommandExecutedStatus commandExecutedStatus, String message) {
        this(commandExecutedStatus);
        this.message = message;
    }

    public CommandExecuteResult() {
    }


    public CommandExecuteResult(MessageHandlerResult result) {

        if (null == result) {
            return;
        }


    }
}
