package com.cleverframekwork.samples.beans.doante.commandhandler;

import com.cleverframekwork.samples.beans.doante.command.*;
import com.cleverframekwork.samples.beans.doante.domain.beansaccount.BeansAccount;
import com.cleverframekwork.samples.beans.doante.messages.BeansAccountValidateFailMessage;
import com.cleverframekwork.samples.beans.doante.messages.BeansAccountValidatePassedMessage;
import com.cleverframekwork.samples.beans.doante.messages.BeansNotEnoughException;
import org.cleverframework.commands.CommandContext;
import org.cleverframework.messages.ApplicationMessage;
import org.springframework.stereotype.Component;

@Component
public class BeansAccountCommandHandler {

    //创建豆豆账户
    public void handle(CommandContext commandContext, CreateBeansAccountCommand command) {

        commandContext.add(new BeansAccount(command.getDonateAccountId(), command.getBeansNumber()));
    }

    //重置豆豆账户余额
    public void handle(CommandContext commandContext, ResetBeansAccountCommand command) {

        BeansAccount beansAccount = commandContext.get(command.getBeansAccountId());

        beansAccount.reset(command.getBeansNumber());
    }

    /**
     * 减少豆豆
     *
     * @param commandContext
     * @param command
     */
    public void handle(CommandContext commandContext, DecreaseBeansCommand command) {

        BeansAccount beansAccount = commandContext.get(command.getDonaterAccountId());

        beansAccount.decrease(command.getDecreaseNumber());
    }

    /**
     * 验证豆豆账户
     *
     * @param commandContext
     * @param command
     * @return
     */
    public ApplicationMessage handle(CommandContext commandContext, BeanAccountValidateCommand command) {

        if (command.getBeansNumber() > 50) {
            return new BeansAccountValidateFailMessage(command.getBeanAccountId(), command.getDonateId(), "每次赠送不能超过50豆");
        }

        return new BeansAccountValidatePassedMessage(command.getBeanAccountId(), command.getDonateId());
    }

    /**
     * 提交豆豆捐赠
     *
     * @param commandContext
     * @param command
     */
    public void handle(CommandContext commandContext, BeansDonatedCommitCommand command) {

        BeansAccount beansAccount = commandContext.get(command.getSourceAccountId());

        if (beansAccount.getBalance() < command.getDonateNumber()) {
            throw new BeansNotEnoughException(command.getDonateId(), command.getSourceAccountId());
        }

        beansAccount.donate(command.getDonateId(), command.getDonateNumber());
    }
}
