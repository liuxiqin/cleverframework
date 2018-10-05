package org.cleverframework.messages.channels;

/**
 * 通道对象池
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/29 15:09
 */
public interface CommunicateChannelFactoryPool {

    /**
     * 获取发送消息通道
     *
     * @return
     */
    CommunicateChannel getChannel(String topic);

    void addChannel();

}
