package com.cleverframekwork.samples.beans.doante.domain.beansdonate;

import lombok.Data;
import org.cleverframework.domain.DomainEvent;

import java.util.Date;
import java.util.UUID;

@Data
public class BeansDonated extends DomainEvent {

    private String donateId;

    private String sourceAccountId;

    private String targetAccountId;

    private int donateNumber;

    private Date donatedStamp;

    private boolean _isSourceAccountValidatePassed;

    private boolean _isTargetAccountValidatePassed;

    private boolean _isDonateConfirmed;

    public BeansDonated(String donateId, String sourceAccountId, String targetAccountId, int donateNumber) {

        super(UUID.randomUUID().toString());

        this.donateNumber = donateNumber;
        this.donateId = donateId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.donatedStamp = new Date();
    }

}
