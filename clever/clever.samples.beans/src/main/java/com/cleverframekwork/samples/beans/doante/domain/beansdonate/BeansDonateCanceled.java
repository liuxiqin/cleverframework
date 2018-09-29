package com.cleverframekwork.samples.beans.doante.domain.beansdonate;

import lombok.Getter;
import org.cleverframework.domain.DomainEvent;

@Getter
public class BeansDonateCanceled extends DomainEvent {

    private static final long serialVersionUID = 5647699483267892342L;

    public BeansDonateCanceled(String aggregateRootId) {
        super(aggregateRootId);
    }
}
