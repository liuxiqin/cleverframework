package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;

/**
 * Created by Administrator on 2017-04-09 .
 */
public interface CommandProcessor {

    <T extends Command> void process(CommandProcessorContext context) throws Exception;
}