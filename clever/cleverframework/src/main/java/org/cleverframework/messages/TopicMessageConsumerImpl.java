package org.cleverframework.messages;

import com.rabbitmq.client.*;
import com.rabbitmq.client.Consumer;
import org.cleverframework.Infrastructure.serializes.BinarySerializer;
import org.cleverframework.Infrastructure.serializes.BinarySerializerImpl;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.function.*;

/**
 * Created by cass02 on 2017/4/15.
 */
public class TopicMessageConsumerImpl implements MessageConsumer, Runnable {

    private String topic;

    private String routingKey;

    private boolean isActive;

    private ExecutorService executorService;

    private BinarySerializer binarySerializer = new BinarySerializerImpl();

    private Connection connection;

    private Channel channel;

    public TopicMessageConsumerImpl(String topic, String routingKey, ExecutorService executorService) {
        this.topic = topic;
        this.routingKey = routingKey;
        this.executorService = executorService;
    }


    public void start() {

        try {

            ConnectionFactory factory = new ConnectionFactory();

            factory.setHost("localhost");
            factory.setUsername("admin");
            factory.setPassword("123456");
            factory.setPort(5672);
            factory.setRequestedHeartbeat(60);
            //创建一个新的连接
            connection = factory.newConnection(executorService);
            //创建一个通道
            channel = connection.createChannel();

            connection.setId(UUID.randomUUID().toString());

            for (int i = 0; i < 100; i++) {
                Channel tempChannel = connection.createChannel();

                System.out.println("connection:" + connection.getId() + ",channel->" + tempChannel.toString());
            }

            //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello RabbitMQ " + new Date();
            //发送消息到队列中
            channel.exchangeDeclare(topic, BuiltinExchangeType.DIRECT, true);
            channel.queueDeclare(routingKey, true, false, false, null);
            channel.basicQos(1);
            channel.queueBind(routingKey, topic, routingKey);

            Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) {
                    try {
                        Thread.sleep(1000);

                        channel.basicAck(envelope.getDeliveryTag(), true);
                    } catch (Exception e) {
                        try {
                            channel.basicAck(envelope.getDeliveryTag(), false);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        e.printStackTrace();
                    }
                }
            };

            channel.basicConsume(routingKey, true, consumer);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void close() throws Exception {

        if (channel != null && channel.isOpen()) {
            channel.close();
        }

        if (connection != null && connection.isOpen()) {
            connection.close();
        }
    }

    public void run() {
        start();
    }

    public String getName() {
        return this.topic + "_" + this.routingKey;
    }
}