package org.cleverframework.messages;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandTopicProvider;
import org.cleverframework.common.ObjectId;
import org.cleverframework.events.Event;
import org.cleverframework.events.EventTopicProvider;
import org.cleverframework.infrastructure.serializes.JsonSerializer;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/30 17:23
 */
public class MessageWrapperBuilder {

    private JsonSerializer jsonSerializer;

    private CommandTopicProvider commandTopicProvider;

    private EventTopicProvider eventTopicProvider;

    public MessageWrapperBuilder(JsonSerializer jsonSerializer,
                                 CommandTopicProvider commandTopicProvider,
                                 EventTopicProvider eventTopicProvider) {

        this.jsonSerializer = jsonSerializer;
    }

    public MessageWrapper build(Event event) {

        throw new UnsupportedOperationException();
    }

    public MessageWrapper build(Message message) {

        throw new UnsupportedOperationException();
    }

    public <T extends Command> MessageWrapper build(T command, boolean needResponse) {

        MessageWrapper messageWrapper = new MessageWrapper();

        messageWrapper.setTimeStamp(System.currentTimeMillis());
        messageWrapper.setMessageId(ObjectId.getId());
        messageWrapper.setMessageName(command.getClass().getName());
        messageWrapper.setTopic(CommandTopicProvider.getTopic(command));
        messageWrapper.setRoutingKey(command.routingKey());
        messageWrapper.setMessageBody(command);
        messageWrapper.setBodyLength(0);
        messageWrapper.setNeedResponse(needResponse);
        messageWrapper.addAttribute(RemoteEndPoint.RemoteEndPoint_KEY, create());

        return messageWrapper;
    }

    private RemoteEndPoint create() {


        RemoteEndPoint endPoint = new RemoteEndPoint();

        endPoint.setIpAddress("127.0.0.1");
        endPoint.setPort(8081);
        endPoint.setProtocolType(ProtocolType.HTTP);
        endPoint.setServiceName("test-name");

        return endPoint;
    }

}
