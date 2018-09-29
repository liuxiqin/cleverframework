package com.cleverframekwork.samples.beans.doante.command;

import org.cleverframework.commands.Command;

/**
 * Created by Administrator on 2018-05-01 .
 */
public class BeansAccountValidateFailCommand extends Command {

    private static final long serialVersionUID = -7669849835415010133L;

    private String reason;

    public BeansAccountValidateFailCommand(String donateId, String reason) {
        super(donateId);

        this.reason = reason;
    }
}
