package org.cleverframework.messages.pipelines;

import org.cleverframework.infrastructure.serializes.JacksonSerializerImpl;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.Message;
import org.cleverframework.messages.MessageClassContainer;
import org.cleverframework.messages.MessageExecuteContext;

/**
 * 接收消息处理，反序列化
 *
 * @author xiqin.liu
 */
public class ReceivedMessageExecute implements MessageExecute {

    private JsonSerializer jsonSerializer = new JacksonSerializerImpl();

    @Override
    public void execute(MessageExecuteContext context) {

        Message message = jsonSerializer.deSerialize(context.getMessageWrapper().getMessageBody(), Message.class);

        context.setMessage(message);
    }
}
