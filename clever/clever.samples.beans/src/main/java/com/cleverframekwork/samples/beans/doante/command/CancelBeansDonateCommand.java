package com.cleverframekwork.samples.beans.doante.command;

import org.cleverframework.commands.Command;

/**
 * 取消豆子的捐赠
 */
public class CancelBeansDonateCommand extends Command {

    private static final long serialVersionUID = 6427225395196172087L;

    private String donateId;

    public CancelBeansDonateCommand(String donateId) {
        super(donateId);

        this.donateId = donateId;
    }
}
