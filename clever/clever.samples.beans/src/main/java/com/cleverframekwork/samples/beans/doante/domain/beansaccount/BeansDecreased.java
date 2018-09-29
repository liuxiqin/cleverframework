package com.cleverframekwork.samples.beans.doante.domain.beansaccount;

import lombok.Data;
import org.cleverframework.domain.DomainEvent;

import java.util.UUID;

/**
 * 豆子减少
 */
@Data
public class BeansDecreased extends DomainEvent {

    private String accountId;

    private int decreaseNumber;

    public BeansDecreased(String accountId, int decreaseNumber) {
        super(UUID.randomUUID().toString());

        this.accountId = accountId;
        this.decreaseNumber = decreaseNumber;
    }
}
