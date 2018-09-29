package com.cleverframekwork.samples.beans.doante.domain.beansdonate;


import lombok.Data;
import org.cleverframework.domain.AggregateRoot;

import java.util.Date;

@Data
public class BeansDonate extends AggregateRoot {

    private String sourceAccountId;

    private String targetAccountId;

    private int donateNumber;

    private Date donateStamp;

    private DonateStatusEnum status;

    private boolean _isValidateAccountPassed;


    public BeansDonate(String donateId, String sourceAccountId, String targetAccountId, int donateNumber) {
        super(donateId);

        applyEvent(new DonateBeansStarted(donateId, sourceAccountId, targetAccountId, donateNumber));
    }

    public void validatePassed() {

        applyEvent(new BeansAccountValidatePassed(this.getId()));

    }

    public void confirm() {

        applyEvent(new BeansDonateConfirmed(this.getId()));
    }

    public void cancel() {

        applyEvent(new BeansDonateCanceled(this.getId()));
    }

    private void handle(DonateBeansStarted event) {

        this.sourceAccountId = event.getDonateId();
        this.targetAccountId = event.getTargetAccountId();
        this.donateNumber = event.getDonateNumber();
        this.donateStamp = new Date();
        this.status = DonateStatusEnum.UNCOMMITED;
    }

    private void handle(BeansAccountValidatePassed event) {

        this._isValidateAccountPassed = true;
    }

    public void handle(BeansDonateCanceled event) {

        this.status = DonateStatusEnum.CANCEL;
    }

    public void handle(BeansDonateConfirmed event) {

        this.status = DonateStatusEnum.COMMITTED;
    }

}
