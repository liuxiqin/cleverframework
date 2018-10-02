package org.cleverframework.commands;


import org.cleverframework.infrastructure.exceptions.SendCommandException;
import org.cleverframework.messages.MessageWrapperBuilder;
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
public class CommandServiceImpl implements CommandService {

    private MessageRequest messageRequest;

    private MessageWrapperBuilder messageWrapperBuilder;

    public CommandServiceImpl() {

    }

    private final static long DEFAULT_TIMEOUT = 3000;

    @Override
    public <T extends Command> CommandExecuteResult sendAndWait(T command) {

        return this.sendAndWait(command, DEFAULT_TIMEOUT);
    }

    @Override
    public <T extends Command> CommandExecuteResult sendAndWait(T command, long timeout) {

        Future<MessageReply> future = messageRequest.send(messageWrapperBuilder.build(command, true), timeout);

        try {

            return CommandFactory.create(future.get().getResult());

        } catch (Exception e) {

            throw new SendCommandException(command);
        }
    }

    @Override
    public <T extends Command> void sendAsync(T command) {

        messageRequest.sendAsync(messageWrapperBuilder.build(command, false));
    }

    @Override
    public <T extends Command> Future<CommandExecuteResult> send(T command) {

        throw new UnsupportedOperationException();

    }


}
