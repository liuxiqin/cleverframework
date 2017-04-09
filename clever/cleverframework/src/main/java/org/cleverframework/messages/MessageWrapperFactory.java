package org.cleverframework.messages;

import org.cleverframework.commands.Command;

/**
 * Created by cass02 on 2017/4/2.
 */
public class MessageWrapperFactory {

    public static <T extends Command> MessageWrapper create(T command) {


        String topic = command.getClass().getPackage().getName();


        return new MessageWrapper();
    }
}
