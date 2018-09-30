package org.cleverframework.commands;

/**
 * 获取命令的TOPIC
 *
 * @author xiqin.liu
 */
public class CommandTopicProvider {

    public static <T extends Command> String getTopic(T command) {

        return command.getClass().getPackage().getName();
    }
}
