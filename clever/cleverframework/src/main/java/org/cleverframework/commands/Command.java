package org.cleverframework.commands;

import org.cleverframework.messages.Message;

/**
 * 命令抽象类
 *
 * @author xiqin.liu
 */
public abstract class Command extends Message {

    /**
     * 命令变更的对应的聚合根ID
     */
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

    /**
     * 路由键hashcode计算
     *
     * @return
     */
    @Override
    public String routingKey() {
        return this.aggregateRootId;
    }
}
