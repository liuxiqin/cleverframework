package org.cleverframework.example.trade.domains;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.cleverframework.domain.AggregateRoot;
import org.cleverframework.example.trade.domainevents.AccountCreated;
import org.cleverframework.example.trade.domainevents.TelephoneModified;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-03-05 .
 */
public class TradeAccount extends AggregateRoot {

    private String accountId;

    private String accountName;

    private BigDecimal amount;

    private String cardId;

    private String telephone;

    public TradeAccount(String accountId, String accountName, String cardId) {

        super(accountId);
        this.accountId = accountId;
        applyEvent(new AccountCreated(accountId, accountName, cardId));
    }

    public void modifyTelephone(String newTelephone) {

        applyEvent(new TelephoneModified(accountId, newTelephone));
    }


    public void handle(AccountCreated event) {

        this.accountName = event.getAccountName();
        this.cardId = event.getCardId();
    }

    public void handle(TelephoneModified event) {
        this.telephone = event.getNewTelephone();
    }

}
