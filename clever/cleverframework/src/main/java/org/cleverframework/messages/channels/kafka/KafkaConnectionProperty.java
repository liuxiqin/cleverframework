package org.cleverframework.messages.channels.kafka;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * KAFKA 配置
 * broker, producer,consumer
 *
 * @author xiqin.liu
 */
public class KafkaConnectionProperty {

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
    private List<String> topics;

    /**
     * KAFKA 分区数量
     */
    private int partitionCount = 24;

    /**
     * 消费者配置
     */
    private List<kafkaConsumerProperty> consumerProperties = Lists.newArrayList();

    /**
     * KAFKA消息这配置，主题(TOPIC)与消费组(CONSUMER GROUP)
     */
    class kafkaConsumerProperty {

        private String topic;

        private String consumerGroup;

        public kafkaConsumerProperty(String topic, String consumerGroup) {

            this.topic = topic;
            this.consumerGroup = consumerGroup;
        }

        public String getTopic() {
            return topic;
        }

        public String getConsumerGroup() {
            return consumerGroup;
        }
    }

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

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    public List<kafkaConsumerProperty> getConsumerProperties() {
        return consumerProperties;
    }

    public void setConsumerProperties(List<kafkaConsumerProperty> consumerProperties) {
        this.consumerProperties = consumerProperties;
    }

    public void addConsumer(String topic, String consumerGroup) {
        this.consumerProperties.add(new kafkaConsumerProperty(topic, consumerGroup));
    }

}
