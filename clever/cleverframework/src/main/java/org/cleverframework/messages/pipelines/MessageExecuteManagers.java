package org.cleverframework.messages.pipelines;

import org.cleverframework.messages.MessageHandlerContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-16 .
 */
public class MessageExecuteManagers implements MessageExecute {

    private List<MessageExecute> executes = new ArrayList<>();

    public MessageExecuteManagers() {

        executes.add(new ReceivedMessageExecute());
        executes.add(new DispatchMessageExecute());
        executes.add(new ProcessMessageExecute());
        executes.add(new ErrorMessageExecute());
        executes.add(new ResponseMessageExecute());
        executes.add(new AckMessageExecute());
    }

    @Override
    public void execute(MessageHandlerContext messageContext) {

        executes.forEach(messageExecute -> messageExecute.execute(messageContext));
    }
}
