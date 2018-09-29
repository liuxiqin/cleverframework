package org.cleverframework.samples;

/**
 * Created by cass02 on 2017/4/21.
 */
public class ActiveMQConnectionInfo {

    public String userName;

    public String password;

    public String activeMQUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActiveMQUrl() {
        return activeMQUrl;
    }

    public void setActiveMQUrl(String activeMQUrl) {
        this.activeMQUrl = activeMQUrl;
    }

    @Override
    public String toString() {
        return "ActiveMQConnectionInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", activeMQUrl='" + activeMQUrl + '\'' +
                '}';
    }
}
