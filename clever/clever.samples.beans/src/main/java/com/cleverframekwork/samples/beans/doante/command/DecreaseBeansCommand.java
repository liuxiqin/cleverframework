package com.cleverframekwork.samples.beans.doante.command;

import lombok.Data;
import org.cleverframework.commands.Command;

@Data
public class DecreaseBeansCommand extends Command {

    private String donaterAccountId;

    private int decreaseNumber;

    private String donateId;

    public DecreaseBeansCommand(String donateId, String donaterAccountId, int decreaseNumber) {
        super(donaterAccountId);

        this.donaterAccountId = donaterAccountId;
        this.decreaseNumber = decreaseNumber;
        this.donateId = donateId;
    }
}
