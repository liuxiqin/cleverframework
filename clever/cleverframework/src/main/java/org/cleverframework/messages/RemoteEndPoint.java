package org.cleverframework.messages;

/**
 * 机器目标地址
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 12:48
 */
public class RemoteEndPoint {

    public static final String RemoteEndPoint_KEY = "RemoteEndPoint";

    /**
     * IP地址
     */
    private String ipAddress;

    /**
     * 端口
     */
    private int port;

    /**
     * 目标地址名称
     */
    private String serviceName;

    /**
     * 协议类型
     */
    private ProtocolType protocolType;


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ProtocolType getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }
}
