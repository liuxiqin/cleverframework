package org.cleverframework.messages.pipelines;

import org.cleverframework.commands.Command;
import org.cleverframework.events.Event;
import org.cleverframework.messages.Message;
import org.cleverframework.messages.MessageExecuteContext;

/**
 * Created by cass02 on 2017/4/2.
 */
public class ProcessMessageExecute implements MessageExecute {

    public void execute(MessageExecuteContext context) {

        Message message = context.getMessage();

        if (message instanceof Command) {
              
        }
        if (message instanceof Event) {

        }

    }
}
