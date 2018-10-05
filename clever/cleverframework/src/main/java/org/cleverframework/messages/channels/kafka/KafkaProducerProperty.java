package org.cleverframework.messages.channels.kafka;

/**
 * kafka 生产者配置
 *
 * @author xiqin.liu
 */
public class KafkaProducerProperty {

    /**
     * kafka broker
     */
    private String brokers;

    /**
     * 连接超时时间
     */
    private long timeout;

    /**
     * 消息发送TOPIC
     */
    private String topic;

    /**
     * KAFKA 分区数量
     */
    private int partitionCount = 24;

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

    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }
}
