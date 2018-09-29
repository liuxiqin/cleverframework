package com.cleverframekwork.samples.beans.doante.messages;

import lombok.Getter;
import org.cleverframework.infrastructure.exceptions.PublishableException;

/**
 * 豆豆不够异常
 */
@Getter
public class BeansNotEnoughException extends PublishableException {

    private String donateId;

    private String beansAccountId;

    public BeansNotEnoughException(String donateId, String beansAccountId) {

        this.donateId = donateId;
        this.beansAccountId = beansAccountId;
    }

}
