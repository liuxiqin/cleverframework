package com.cleverframekwork.samples.beans.doante.command;

import lombok.Data;
import lombok.experimental.Accessors;
import org.cleverframework.commands.Command;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class DonateBeansCommand extends Command {

    private String sourceAccountId;

    private String targetAccountId;

    private int beansNumber;

    public DonateBeansCommand(String sourceAccountId, String targetAccountId, int beansNumber) {

        super(UUID.randomUUID().toString());

        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.beansNumber = beansNumber;
    }
}
