package com.cleverframekwork.samples.beans.doante.command;

import lombok.Data;
import org.cleverframework.commands.Command;


@Data
public class ConfirmBeansCommand extends Command {

    private static final long serialVersionUID = -2904392083562554880L;

    public ConfirmBeansCommand(String donateId) {
        super(donateId);
    }
}
