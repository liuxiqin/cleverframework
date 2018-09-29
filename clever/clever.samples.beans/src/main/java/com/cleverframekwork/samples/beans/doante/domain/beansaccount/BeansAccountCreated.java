package com.cleverframekwork.samples.beans.doante.domain.beansaccount;

import lombok.Data;
import org.cleverframework.domain.DomainEvent;

import java.util.UUID;

@Data
public class BeansAccountCreated extends DomainEvent {

    public String accountId;

    public int initNumber;

    public BeansAccountCreated(String accountId, int initNumber) {

        super(UUID.randomUUID().toString());

        this.accountId = accountId;
        this.initNumber = initNumber;
    }
}
