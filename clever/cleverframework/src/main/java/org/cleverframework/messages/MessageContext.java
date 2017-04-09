package org.cleverframework.messages;

import java.util.List;

/**
 * Created by cass02 on 2017/4/2.
 */
public class MessageContext {

    private MessageExecuteResult messageExecuteResult;

    private List<MessageWrapper> messageWrappers;

    public MessageContext(List<MessageWrapper> messageWrappers) {
       this.messageWrappers = messageWrappers;
    }

    public List<MessageWrapper> getMessageWrappers(){
        return this.messageWrappers;
    }

    public void setMessageExecuteResult(){



    }
}
