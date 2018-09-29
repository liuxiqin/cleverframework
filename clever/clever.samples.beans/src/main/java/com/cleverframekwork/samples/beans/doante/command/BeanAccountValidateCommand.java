package com.cleverframekwork.samples.beans.doante.command;


import lombok.Data;
import org.cleverframework.commands.Command;

@Data
public class BeanAccountValidateCommand extends Command {

    private String donateId;

    private String beanAccountId;

    private int beansNumber;

    public BeanAccountValidateCommand(String donateId,
                                      String beanAccountId,
                                      int beansNumber) {
        super(donateId);

        this.donateId = donateId;
        this.beanAccountId = beanAccountId;
        this.beansNumber = beansNumber;
    }
}
