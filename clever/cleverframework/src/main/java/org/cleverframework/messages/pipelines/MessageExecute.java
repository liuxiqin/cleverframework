package org.cleverframework.messages.pipelines;

import org.cleverframework.messages.MessageContext;

/**
 * Created by cass02 on 2017/4/2.
 */
public interface MessageExecute {
    void execute(MessageContext context);
}
