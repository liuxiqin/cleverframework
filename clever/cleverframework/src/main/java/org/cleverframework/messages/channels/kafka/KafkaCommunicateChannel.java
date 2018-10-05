package org.cleverframework.messages.channels.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.cleverframework.infrastructure.exceptions.MessageProducerFailException;
import org.cleverframework.infrastructure.serializes.JsonSerializer;
import org.cleverframework.messages.MessageWrapper;
import org.cleverframework.messages.channels.CommunicateChannel;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/29 15:14
 */
public class KafkaCommunicateChannel implements CommunicateChannel {

    private KafkaProducerProperty producerProperty;

    private JsonSerializer jsonSerializer;

    private Producer<String, String> producer;

    public KafkaCommunicateChannel(KafkaProducerProperty producerProperty,
                                   JsonSerializer jsonSerializer) {

        this.producerProperty = producerProperty;
        this.jsonSerializer = jsonSerializer;

        producer = new KafkaProducer<>(createProperties());
    }


    @Override
    public void publish(MessageWrapper message) {

        Future<RecordMetadata> sent = producer.send(new ProducerRecord<>(
                message.getTopic(),
                getPartition(message),
                message.getMessageId(),
                jsonSerializer.serialize(message)));

        producer.flush();

        try {
            RecordMetadata recordMetadata = sent.get(producerProperty.getTimeout(), TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            throw new MessageProducerFailException(message, e);
        }
    }

    @Override
    public void publish(List<MessageWrapper> messages) {

        for (MessageWrapper message : messages) {

            producer.send(new ProducerRecord<>(
                    message.getTopic(),
                    getPartition(message),
                    message.getMessageId(),
                    jsonSerializer.serialize(message)));
        }

        producer.flush();
    }

    @Override
    public void close() {

    }

    private int getPartition(MessageWrapper message) {

        return message.getRoutingKey().hashCode() % producerProperty.getPartitionCount();
    }

    public Properties createProperties() {

        Properties props = new Properties();
        props.put("bootstrap.servers", producerProperty);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return createProperties();
    }

}
