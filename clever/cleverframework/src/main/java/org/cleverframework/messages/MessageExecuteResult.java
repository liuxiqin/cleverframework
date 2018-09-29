package org.cleverframework.messages;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;

/**
 * @author xiqin.liu
 */
public class MessageExecuteResult implements Serializable {

    private String exceptionMessage;

    private Boolean success;

    private String result;

    private String messageId;

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "MessageExecuteResult{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                ", success=" + success +
                ", result='" + result + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
