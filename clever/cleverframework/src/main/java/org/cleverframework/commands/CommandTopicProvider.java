package org.cleverframework.commands;

/**
 * Created by cass02 on 2017/4/15.
 */
public class CommandTopicProvider {

    public static  <T extends Command> String getTopic(T command) {
        return command.getClass().getPackage().getName();
    }
}
