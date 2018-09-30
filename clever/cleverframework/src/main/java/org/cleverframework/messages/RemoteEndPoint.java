package org.cleverframework.messages;

/**
 * 机器目标地址
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 12:48
 */
public class RemoteEndPoint {

    /**
     * IP地址
     */
    private String ipaddress;

    /**
     * 端口
     */
    private int port;

    /**
     * 目标地址名称
     */
    private String serviceName;


    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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
}
