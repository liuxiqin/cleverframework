package org.cleverframework.messages.reply;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 消息应答池
 *
 * @author xiqin.liu
 */
public class MessageReplyPool {

    private final static ConcurrentHashMap<String, MessageReply> messageReplyPools = new ConcurrentHashMap<>();


    public static MessageReply getAndRemoveMessageReply(String messageId) {

        if (!messageReplyPools.containsKey(messageId)) {
            return null;
        }

        MessageReply messageReply = messageReplyPools.get(messageId);

        messageReplyPools.remove(messageId);

        return messageReply;
    }

    public static MessageReply tryAddMessageReply(String messageId, long timeout) {

        MessageReply messageReply = new MessageReplyImpl(messageId, timeout);

        return messageReplyPools.put(messageId, messageReply);

    }

}
