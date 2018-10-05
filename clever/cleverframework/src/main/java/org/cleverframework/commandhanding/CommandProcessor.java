package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;

/**
 * 命令处理接口抽象
 *
 * @author xiqin.liu
 */
public interface CommandProcessor {

    <T extends Command> void process(CommandProcessorContext context);
}