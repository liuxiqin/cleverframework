package com.cleverframekwork.samples.beans.doante.commandhandler;


import com.cleverframekwork.samples.beans.doante.command.BeansAccountValidatePassedCommand;
import com.cleverframekwork.samples.beans.doante.command.CancelBeansDonateCommand;
import com.cleverframekwork.samples.beans.doante.command.ConfirmBeansCommand;
import com.cleverframekwork.samples.beans.doante.command.DonateBeansCommand;
import com.cleverframekwork.samples.beans.doante.domain.beansdonate.BeansDonate;
import org.cleverframework.commands.CommandContext;
import org.springframework.stereotype.Component;

@Component
public class BeansDonateCommandHandler {

    private void handle(CommandContext context, DonateBeansCommand command) {

        context.add(
                new BeansDonate(
                        command.getAggregateRootId(),
                        command.getSourceAccountId(),
                        command.getTargetAccountId(),
                        command.getBeansNumber()));
    }

    private void handle(CommandContext context, BeansAccountValidatePassedCommand command) {

        BeansDonate donate = context.get(command.getAggregateRootId());

        donate.validatePassed();
    }

    private void handle(CommandContext context, CancelBeansDonateCommand command) {

        BeansDonate donate = context.get(command.getAggregateRootId());

        donate.cancel();
    }

    private void handle(CommandContext context, ConfirmBeansCommand command) {

        BeansDonate donate = context.get(command.getAggregateRootId());

        donate.confirm();
    }
}
