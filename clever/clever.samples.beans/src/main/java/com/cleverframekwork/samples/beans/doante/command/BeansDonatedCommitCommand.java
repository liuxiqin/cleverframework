package com.cleverframekwork.samples.beans.doante.command;

import lombok.Getter;
import org.cleverframework.commands.Command;


@Getter
public class BeansDonatedCommitCommand extends Command {

    private static final long serialVersionUID = 2904704316555115340L;

    private String donateId;

    private String sourceAccountId;

    private String targetAccountId;

    private int donateNumber;

    public BeansDonatedCommitCommand(String donateId,
                                     String sourceAccountId,
                                     String targetAccountId,
                                     int donateNumber) {
        super(donateId);

        this.donateId = donateId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.donateNumber = donateNumber;


    }
}
