package org.cleverframework.messages.channels.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;


/**
 * 自定义消息分区策略
 */
public class CustomPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] bytes, Object value, byte[] bytes1, Cluster cluster) {

        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);

        int numPartitions = partitions.size();

        return key.hashCode() & numPartitions;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
