package com.cleverframekwork.samples.beans.doante.command;

import lombok.Data;
import lombok.experimental.Accessors;
import org.cleverframework.commands.Command;

import java.util.UUID;


@Accessors
@Data
public class CreateBeansAccountCommand extends Command {

    private int beansNumber;

    private String donateAccountId;

    public CreateBeansAccountCommand(String donateAccountId, int beansNumber) {
        super(UUID.randomUUID().toString());

        this.beansNumber = beansNumber;
        this.donateAccountId = donateAccountId;
    }
}
