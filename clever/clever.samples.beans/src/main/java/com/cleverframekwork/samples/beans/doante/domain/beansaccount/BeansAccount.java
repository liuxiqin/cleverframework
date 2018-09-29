package com.cleverframekwork.samples.beans.doante.domain.beansaccount;

import com.cleverframekwork.samples.beans.doante.domain.beansdonate.DonateBeansCommitted;
import lombok.Data;
import org.cleverframework.domain.AggregateRoot;
import org.springframework.util.Assert;

import java.util.Date;

@Data
public class BeansAccount extends AggregateRoot {


    /**
     * 账号ID
     */

    private String accountId;

    /**
     * 开心豆余额
     */
    private int balance;

    private Date createdStamp;

    /**
     * 冻结
     */
    //private int freezeNumber;

    private Date lastUpdatedStamp;

    private int version;

    public BeansAccount(String accountId, int initNumber) {

        Assert.notNull(accountId, "accountid can not be null.");
        Assert.isTrue(initNumber <= 0, "number of beans must be more than zero.");

        applyEvent(new BeansAccountCreated(accountId, initNumber));
    }

    /**
     * 重置 开心豆
     *
     * @param beansNumber
     */
    public void reset(int beansNumber) {

        Assert.isTrue(beansNumber > 0, "number of beans must be more than zero.");

        applyEvent(new BeansAccountReset(this.accountId, beansNumber));
    }

    public void decrease(int decreaseNumber) {

        Assert.isTrue(decreaseNumber > 0, "decreaseNumber must be more than zero.");
        Assert.isTrue(this.balance > decreaseNumber, "balance must be more than decreaseNumber");

        applyEvent(new BeansDecreased(this.accountId, decreaseNumber));
    }

    public void donate(String donateId, int donateNumber) {

        applyEvent(new DonateBeansCommitted(donateId, donateNumber));
    }


    private void handle(BeansAccountCreated event) {

        this.accountId = event.getAccountId();
        this.balance = event.getInitNumber();
        this.createdStamp = new Date();
        this.lastUpdatedStamp = new Date();
        this.version = 0;
    }

    private void handle(BeansAccountReset event) {

        this.balance = event.getResetNumber();
        this.version++;
        this.lastUpdatedStamp = new Date();
    }

    private void handle(BeansDecreased event) {

        this.balance = this.balance - event.getDecreaseNumber();
        this.version++;
        this.lastUpdatedStamp = new Date();
    }

    private void handle(DonateBeansCommitted event) {

        this.balance = this.balance - event.getBeansNumber();
        this.version++;
        this.lastUpdatedStamp = new Date();
    }
}
