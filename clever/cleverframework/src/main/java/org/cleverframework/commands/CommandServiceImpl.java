package org.cleverframework.commands;


import org.cleverframework.messages.MessageProducer;
import org.cleverframework.messages.MessageWrapper;

import javax.annotation.Resource;

@Resource
public class CommandServiceImpl implements CommandService {

    private MessageProducer producer;

    public <T extends Command> CommandExecuteResult send(T command) {

        return null;
    }

    public <T extends Command> void sendOneWay(T command) {

    }

    private <T extends Command> MessageWrapper buildMessage(T command, boolean needResponse) {
        return new MessageWrapper();
    }
}
