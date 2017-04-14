package org.cleverframework.example.trader.domainevents;

import org.cleverframework.domain.DomainEvent;

/**
 * Created by Administrator on 2017-03-06 .
 */
public class TelephoneModified extends DomainEvent {

    private final String accountId;

    private final String newTelephone;

    public TelephoneModified(String accountId, String newTelephone) {

        super(accountId);
        this.accountId = accountId;
        this.newTelephone = newTelephone;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getNewTelephone() {
        return this.newTelephone;
    }

}
