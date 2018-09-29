package com.cleverframekwork.samples.beans.doante.command;


import lombok.Data;
import lombok.experimental.Accessors;
import org.cleverframework.commands.Command;

import java.util.UUID;

@Data
@Accessors
public class ResetBeansAccountCommand extends Command {

    private String beansAccountId;

    private int beansNumber;

    public ResetBeansAccountCommand(String beansAccountId, int beansNumber) {
        super(UUID.randomUUID().toString());

        this.beansAccountId = beansAccountId;
        this.beansNumber = beansNumber;
    }
}
