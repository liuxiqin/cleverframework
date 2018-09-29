package com.cleverframekwork.samples.beans.doante.messages;

import lombok.Data;
import org.cleverframework.messages.ApplicationMessage;

/**
 * Created by Administrator on 2018-04-18 .
 */
@Data
public class BeansAccountValidatePassedMessage extends ApplicationMessage {

    private String beansAccountId;

    private String donateId;

    public BeansAccountValidatePassedMessage(String beansAccountId, String donateId) {

        this.beansAccountId = beansAccountId;
        this.donateId = donateId;
    }
}
