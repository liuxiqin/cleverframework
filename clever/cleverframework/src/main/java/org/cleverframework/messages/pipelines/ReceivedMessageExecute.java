package org.cleverframework.messages.pipelines;

import org.cleverframework.infrastructure.serializes.JacksonSerializerImpl;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.Message;
import org.cleverframework.messages.MessageHandlerContext;

/**
 * 接收消息处理，反序列化
 *
 * @author xiqin.liu
 */
public class ReceivedMessageExecute implements MessageExecute {

    private JsonSerializer jsonSerializer = new JacksonSerializerImpl();

    @Override
    public void execute(MessageHandlerContext context) {
 
        context.setMessage(context.getMessageWrapper().getMessageBody());
    }
}
