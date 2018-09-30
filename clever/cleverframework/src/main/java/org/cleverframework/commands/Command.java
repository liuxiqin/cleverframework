package org.cleverframework.commands;

import org.cleverframework.messages.Message;

/**
 * 命令抽象类
 */
public abstract class Command extends Message {

    private String aggregateRootId;

    public Command(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public String getAggregateRootId() {
        return this.aggregateRootId;
    }

    public String getCommandId() {
        return this.getMessageId();
    }

}
