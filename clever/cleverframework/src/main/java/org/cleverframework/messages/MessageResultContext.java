package org.cleverframework.messages;

/**
 * 消息处理结果上下文
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 12:47
 */
public class MessageResultContext {

    /**
     * 消息处理执行结果
     */
    private MessageHandlerResult result;

    /**
     * 消息需要发送的目标地址
     */
    private RemoteEndPoint remoteEndPoint;

    public MessageHandlerResult getResult() {
        return result;
    }

    public void setResult(MessageHandlerResult result) {
        this.result = result;
    }

    public RemoteEndPoint getRemoteEndPoint() {
        return remoteEndPoint;
    }

    public void setRemoteEndPoint(RemoteEndPoint remoteEndPoint) {
        this.remoteEndPoint = remoteEndPoint;
    }

    @Override
    public String toString() {

        return null;
    }
}
