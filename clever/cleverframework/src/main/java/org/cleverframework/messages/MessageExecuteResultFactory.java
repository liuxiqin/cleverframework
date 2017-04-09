package org.cleverframework.messages;

/**
 * Created by Administrator on 2017-04-09 .
 */
public class MessageExecuteResultFactory {

    public static MessageExecuteResult create(String messageId, boolean success) {

        MessageExecuteResult executeResult = new MessageExecuteResult();

        executeResult.setMessageId(messageId);
        executeResult.setSuccess(success);

        return executeResult;
    }

    public static MessageExecuteResult create(String messageId, String exceptionError) {

        MessageExecuteResult executeResult = new MessageExecuteResult();

        executeResult.setMessageId(messageId);
        executeResult.setSuccess(false);
        executeResult.setExceptionMessage(exceptionError);

        return executeResult;
    }


}
