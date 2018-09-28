package org.cleverframework.messages.pipelines;

import org.cleverframework.infrastructure.serializes.JacksonSerializerImpl;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.Message;
import org.cleverframework.messages.MessageClassContainer;
import org.cleverframework.messages.MessageContext;

/**
 * Created by cass02 on 2017/4/2.
 */
public class ReceivedMessageExecute implements MessageExecute {

    private JsonSerializer jsonSerializer = new JacksonSerializerImpl();

    public void execute(MessageContext context) {

        String messageName = context.getMessageWrapper().getMessageName();

        Class<?> messageClass = MessageClassContainer.get(messageName);

        Message message = jsonSerializer.deSerialize(context.getMessageWrapper().getMessageBody(), messageClass);

        context.setMessage(message);
    }
}
