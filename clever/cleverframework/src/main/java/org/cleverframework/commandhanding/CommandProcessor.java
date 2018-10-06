package org.cleverframework.commandhanding;

import org.cleverframework.commands.Command;
import org.cleverframework.commands.CommandProcessorContext;

/**
 * 命令处理接口抽象
 *
 * @author xiqin.liu
 */
public interface CommandProcessor {

    /**
     * 命令处理方法
     *
     * @param context 命令处理上下文
     * @param <T>     Command
     */
    <T extends Command> void execute(CommandProcessorContext context);
}