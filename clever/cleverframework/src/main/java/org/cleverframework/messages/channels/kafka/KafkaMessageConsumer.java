package org.cleverframework.messages.channels.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.cleverframework.messages.*;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: xiqin.liu
 * @Date: 2018/10/5 13:56
 */
public class KafkaMessageConsumer implements MessageConsumer {

    private final static String AUTO_OFFSET_RESET_POSITION_EARLIEST = "earliest";

    private AtomicBoolean isRunning = new AtomicBoolean(false);

    private KafkaConsumerProperty consumerProperty;

    private MessageConverter messageConverter;

    private MessageDispatcher messageDispatcher;

    private KafkaConsumer<String, String> consumer;

    public KafkaMessageConsumer(KafkaConsumerProperty consumerProperty, MessageConverter messageConverter, MessageDispatcher messageDispatcher) {

        this.consumerProperty = consumerProperty;
    }

    @Override
    public void start() {

        consumer = new KafkaConsumer<>(toProperties(consumerProperty));

        consumer.subscribe(Collections.singletonList(consumerProperty.getTopic()));

        while (this.isRunning.get()) {

            try {

                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(500L));

                if (null == records || records.isEmpty()) {
                    continue;
                }

                for (TopicPartition topicPartition : records.partitions()) {

                    long lastOffset = handle(records, topicPartition);

                    consumer.commitSync(Collections.singletonMap(topicPartition, new OffsetAndMetadata(lastOffset + 1)));
                }

            } catch (Exception e) {

            }
        }

        consumer.close();
    }

    @Override
    public void stop() {

        while (isRunning.get()) {

            if (!isRunning.compareAndSet(true, false)) {

                continue;
            }
        }
    }

    @Override
    public String getName() {

        return String.format("%s_%s", this.consumerProperty.getTopic(), this.consumerProperty.getConsumerGroup());
    }

    @Override
    public void run() {

        this.isRunning.compareAndSet(false, true);

        try {

            this.start();
        } catch (Exception e) {

        }
    }

    protected Properties toProperties(KafkaConsumerProperty consumerProperty) {

        Properties props = new Properties();

        props.put("bootstrap.servers", consumerProperty.getBrokers());
        props.put("group.id", consumerProperty.getConsumerGroup());
        props.put("enable.auto.commit", false);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("auto.offset.reset", AUTO_OFFSET_RESET_POSITION_EARLIEST);

        return props;
    }


    /**
     * @param records
     * @return lastOffset 最后消费的offset 偏移量
     */
    protected long handle(ConsumerRecords<String, String> records, TopicPartition topicPartition) {

        List<ConsumerRecord<String, String>> partitionRecords = records.records(topicPartition);

        long offset = partitionRecords.get(partitionRecords.size() - 1).offset();

        for (ConsumerRecord<String, String> record : partitionRecords) {

            try {

                MessageWrapper messageWrapper = messageConverter.toObject(record.value(), MessageWrapper.class);

                MessageHandlerContext context = new MessageHandlerContext(messageWrapper);

                MessageHandlerResult result = messageDispatcher.dispatch(context);

                if (MessageHandlerStatus.SUCCESS != result.getStatus()) {

                    if (record.offset() < offset) {
                        offset = record.offset();
                    }
                }

            } catch (Exception e) {


            }
        }

        return offset;
    }

}
