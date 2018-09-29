package org.cleverframework.messages;

import com.rabbitmq.client.Channel;
import org.cleverframework.messages.channels.MessageChannel;
import sun.misc.resources.Messages_sv;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cass02 on 2017/4/2.
 */
public class MessageContext implements Serializable {

    private static final long serialVersionUID = -4546253438746170496L;

    private  MessageExecuteResult messageExecuteResult;

    private final MessageWrapper messageWrapper;

    private long deliveryTag = 0;

    private MessageChannel messageChannel;

    private Message message;

    private final String messageId;

    public MessageContext(MessageChannel channel, long deliveryTag, MessageWrapper messageWrapper) {

        this.messageChannel = channel;
        this.deliveryTag = deliveryTag;
        this.messageWrapper = messageWrapper;
        this.messageId = messageWrapper.getMessageId();
    }

    public long getDeliveryTag() {
        return this.deliveryTag;
    }

    public MessageChannel getMessageChannel() {

        return this.messageChannel;
    }

    public MessageWrapper getMessageWrapper() {
        return this.messageWrapper;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getMessageId(){
        return this.messageId;
    }


}

