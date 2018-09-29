package com.cleverframekwork.samples.beans.doante.command;

import org.cleverframework.commands.Command;

/**
 * Created by Administrator on 2018-05-01 .
 */
public class BeansAccountValidatePassedCommand extends Command {

    private static final long serialVersionUID = 1188301993828565404L;

    public BeansAccountValidatePassedCommand(String donateId) {
        super(donateId);
    }
}
