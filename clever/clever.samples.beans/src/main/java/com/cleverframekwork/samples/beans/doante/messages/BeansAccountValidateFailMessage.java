package com.cleverframekwork.samples.beans.doante.messages;

import lombok.Data;
import org.cleverframework.messages.ApplicationMessage;


@Data
public class BeansAccountValidateFailMessage extends ApplicationMessage {

    private String beansAccountId;

    private String donateId;

    private String reason;

    public BeansAccountValidateFailMessage(String beansAccountId, String donateId, String reason) {

        this.beansAccountId = beansAccountId;
        this.reason = reason;
        this.donateId = donateId;
    }

}
