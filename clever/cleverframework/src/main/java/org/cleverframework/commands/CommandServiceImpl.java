package org.cleverframework.commands;


import org.cleverframework.Infrastructure.serializes.JacksonSerializerImpl;
import org.cleverframework.Infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.MessageProducer;
import org.cleverframework.messages.MessageWrapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Resource
public class CommandServiceImpl implements CommandService {

    private JsonSerializer jsonSerializer = new JacksonSerializerImpl();

    private MessageProducer producer;

    public <T extends Command> CommandExecuteResult sendAndWait(T command) {

        return null;
    }

    public <T extends Command> void sendAsync(T command) {

    }

    private <T extends Command> MessageWrapper buildMessage(T command, boolean needResponse) throws Exception {

        MessageWrapper messageWrapper = new MessageWrapper();

        messageWrapper.setTimeStamp(new Date().getTime());
        messageWrapper.setMessageId(UUID.randomUUID().toString());
        messageWrapper.setMessageName(command.getClass().getName());
        messageWrapper.setTopic(CommandTopicProvider.getTopic(command));
        messageWrapper.setRoutingKey(CommandTopicProvider.getTopic(command));
        messageWrapper.setMessageBody(jsonSerializer.serialize(command));
        messageWrapper.setBodyLength(messageWrapper.getMessageBody().length());

        return messageWrapper;
    }

}
