package org.cleverframework.messages.channels.kafka;

/**
 * kafka 消费者配置
 *
 * @Author: xiqin.liu
 * @Date: 2018/10/5 13:02
 */
public class KafkaConsumerProperty {

    private String brokers;

    private long timeout;

    private String topic;

    private String consumerGroup;

    public String getBrokers() {
        return brokers;
    }

    public void setBrokers(String brokers) {
        this.brokers = brokers;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }
}
