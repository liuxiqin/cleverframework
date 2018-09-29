package com.cleverframekwork.samples.beans.doante.domain.beansdonate;

import org.cleverframework.domain.DomainEvent;

/**
 * Created by Administrator on 2018-05-01 .
 */
public class BeansDonateConfirmed extends DomainEvent {

    private static final long serialVersionUID = 5342169962763920967L;

    public BeansDonateConfirmed(String aggregateRootId) {
        super(aggregateRootId);
    }

}
