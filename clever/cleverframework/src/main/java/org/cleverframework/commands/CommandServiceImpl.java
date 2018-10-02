package org.cleverframework.commands;


import org.cleverframework.common.ObjectId;
import org.cleverframework.infrastructure.dependency.Component;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.reply.MessageReply;
import org.cleverframework.messages.request.MessageRequest;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 命令消息发送实现
 *
 * @author xiqin.liu
 */
@Component
public class CommandServiceImpl implements CommandService {

    @Resource
    private JsonSerializer jsonSerializer;

    @Resource
    private MessageRequest messageRequest;

    private final static long DEFAULT_TIMEOUT = 3000;

    @Override
    public <T extends Command> CommandExecuteResult sendAndWait(T command) {

        return this.sendAndWait(command, DEFAULT_TIMEOUT);
    }

    @Override
    public <T extends Command> CommandExecuteResult sendAndWait(T command, long timeout) {

        Future<MessageReply> future = messageRequest.send(buildMessage(command, true), timeout);

        try {

            return CommandFactory.create(future.get().getResult());

        } catch (Exception e) {

            throw new RuntimeException();
        }
    }

    @Override
    public <T extends Command> void sendAsync(T command) {

        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Command> FutureTask<CommandExecuteResult> send(T command) {

        throw new UnsupportedOperationException();
    }


    private <T extends Command> MessageWrapper buildMessage(T command, boolean needResponse) {

        MessageWrapper messageWrapper = new MessageWrapper();

        messageWrapper.setTimeStamp(System.currentTimeMillis());
        messageWrapper.setMessageId(ObjectId.getNextId());
        messageWrapper.setMessageName(command.getClass().getName());
        messageWrapper.setTopic(CommandTopicProvider.getTopic(command));
        messageWrapper.setRoutingKey(CommandTopicProvider.getTopic(command));
        messageWrapper.setMessageBody(jsonSerializer.serialize(command));
        messageWrapper.setBodyLength(messageWrapper.getMessageBody().length());
        messageWrapper.setNeedResponse(needResponse);

        return messageWrapper;
    }

}
