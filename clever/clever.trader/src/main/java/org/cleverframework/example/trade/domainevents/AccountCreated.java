package org.cleverframework.example.trade.domainevents;

import org.cleverframework.domain.DomainEvent;

/**
 * Created by Administrator on 2017-03-05 .
 */
public class AccountCreated extends DomainEvent {

    public AccountCreated(String aggregateRootId, String accountName, String cardId) {
        super(aggregateRootId);

        this.accountId = aggregateRootId;
        this.accountName = accountName;
        this.cardId = cardId;
    }

    private final String accountId;

    private final String accountName;

    private final String cardId;

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getCardId() {
        return cardId;
    }

}
