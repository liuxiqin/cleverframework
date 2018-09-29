package org.cleverframework.commands;

import org.cleverframework.messages.MessageHandlerResult;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/29 17:42
 */
public class CommandFactory {

    public static CommandExecuteResult create(MessageHandlerResult result) {

        if (null == result) {
            return null;
        }

        CommandExecuteResult commandResult = new CommandExecuteResult();

        commandResult.setCommandExecutedStatus(CommandExecutedStatus.SUCCESS);

        commandResult.setMessage(result.getMessage());

        return commandResult;
    }
}
