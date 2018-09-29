package org.cleverframework.commands;

import java.util.concurrent.FutureTask;

/**
 * 命令消息发送服务
 *
 * @author xiqin.liu
 */
public interface CommandService {

    /**
     * 发送命令并获取命令最终处理结果，此过程为异步,需要阻塞等待结果，默认超时时间为3S
     *
     * @param command 命令消息
     * @param <T>     Command
     * @return CommandExecuteResult
     */
    <T extends Command> CommandExecuteResult sendAndWait(T command);

    /**
     * 发送命令并获取命令最终处理结果，此过程为异步,需要阻塞等待结果, 自定义超时时间
     *
     * @param command 命令消息
     * @param timeout 获取结果超时时间
     * @param <T>     Command
     * @return CommandExecuteResult
     */
    <T extends Command> CommandExecuteResult sendAndWait(T command, long timeout);

    /**
     * 发送命令不需要获取最终结果
     *
     * @param command 命令消息
     * @param <T>     Command
     */
    <T extends Command> void sendAsync(T command);


    /**
     * 发送命令并获取命令最终处理结果，此过程为异步，自定义获取结果
     *
     * @param command 命令消息
     * @param <T>     Command
     * @return 返回 FutureTask 任务
     */
    <T extends Command> FutureTask<CommandExecuteResult> send(T command);
}