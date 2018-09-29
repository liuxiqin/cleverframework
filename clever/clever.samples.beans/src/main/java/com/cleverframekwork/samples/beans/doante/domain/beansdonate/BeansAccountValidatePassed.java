package com.cleverframekwork.samples.beans.doante.domain.beansdonate;

import lombok.Getter;
import org.cleverframework.domain.DomainEvent;

/**
 * Created by Administrator on 2018-05-01 .
 */
@Getter
public class BeansAccountValidatePassed extends DomainEvent {

    private static final long serialVersionUID = 1323478108452540936L;

    public BeansAccountValidatePassed(String aggregateRootId) {
        super(aggregateRootId);
    }
}
