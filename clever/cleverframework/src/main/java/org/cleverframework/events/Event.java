package org.cleverframework.events;

import org.cleverframework.messages.Message;

/**
 * 事件抽象类
 */
public abstract class Event extends Message {

    private int version;

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return this.version;
    }

}
