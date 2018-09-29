package com.cleverframekwork.samples.beans.doante.domain.beansaccount;


import lombok.Data;
import org.cleverframework.domain.DomainEvent;

import java.util.UUID;

@Data
public class BeansAccountReset extends DomainEvent {

    private String accountId;

    private int resetNumber;

    public BeansAccountReset(String accountId, int resetNumber) {

        super(UUID.randomUUID().toString());

        this.accountId = accountId;
        this.resetNumber = resetNumber;
    }

}
