package com.cleverframekwork.samples.beans.doante.domain.beansdonate;


import lombok.Data;
import org.cleverframework.domain.DomainEvent;

@Data
public class DonateBeansCommitted extends DomainEvent {

    private String doanteId;

    private int beansNumber;

    public DonateBeansCommitted(String messageId, int beansNumber) {

        super(messageId);
    }
}
