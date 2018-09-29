package com.cleverframekwork.samples.beans.doante.processmanager;

import com.cleverframekwork.samples.beans.doante.command.*;
import com.cleverframekwork.samples.beans.doante.domain.beansdonate.DonateBeansCommitted;
import com.cleverframekwork.samples.beans.doante.domain.beansdonate.DonateBeansStarted;
import com.cleverframekwork.samples.beans.doante.messages.BeansAccountValidateFailMessage;
import com.cleverframekwork.samples.beans.doante.messages.BeansAccountValidatePassedMessage;
import com.cleverframekwork.samples.beans.doante.messages.BeansNotEnoughException;
import org.cleverframework.commands.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DonateProcessorManager {

    @Autowired
    private CommandService commandService;

    /**
     * 开始赠送豆子,发送验证账号
     *
     * @param event
     */
    public void handle(DonateBeansStarted event) {

        //验证
        commandService.sendAsync(new BeanAccountValidateCommand(
                event.getDonateId(),
                event.getSourceAccountId(),
                event.getDonateNumber()
        ));

    }

    /**
     * 豆子账户验证失败
     *
     * @param message
     */
    public void handle(BeansAccountValidateFailMessage message) {

        commandService.sendAsync(new BeansAccountValidateFailCommand(message.getDonateId(), message.getReason()));
    }

    /**
     * 豆子账户验证成功
     *
     * @param message
     */
    public void handle(BeansAccountValidatePassedMessage message) {

        commandService.sendAsync(new BeansAccountValidatePassedCommand(message.getDonateId()));
    }

    /**
     * 豆子账户余额不足
     *
     * @param message
     */
    public void handle(BeansNotEnoughException message) {

        commandService.sendAsync(new CancelBeansDonateCommand(message.getDonateId()));
    }

    /**
     * 豆子账户已捐赠出去
     *
     * @param event
     */
    public void handle(DonateBeansCommitted event) {

        commandService.sendAsync(new ConfirmBeansCommand(event.getDoanteId()));
    }
}

