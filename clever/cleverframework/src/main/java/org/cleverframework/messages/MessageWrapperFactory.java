package org.cleverframework.messages;

import org.cleverframework.commands.Command;

/**
 * 消息体封装工厂方法
 */
public class MessageWrapperFactory {

    public static <T extends Command> MessageWrapper create(T command) {


        String topic = command.getClass().getPackage().getName();

        return new MessageWrapper();
    }
}
