package org.cleverframework.commands;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface CommandService {

    <T extends Command> CommandExecuteResult sendAndWait(T command);

    <T extends Command> void sendAsync(T command);


}
