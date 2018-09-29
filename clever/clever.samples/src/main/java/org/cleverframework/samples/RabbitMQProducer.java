package org.cleverframework.samples;

import com.rabbitmq.client.*;


import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.Date;

/**
 * Hello world!
 */
public class RabbitMQProducer {

    private final static String TOPIC = "Seven.Tests";

    private final static String ROUTING_KEY_PREFIX = "Seven.Tests_command_";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        RabbitMQProducer.sendMessage();
        System.out.println("Hello World!");
    }

    private static void sendMessage() throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory factory = new ActiveConnectionFactory();

        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("123456");
        factory.setPort(5672);
        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ " + new Date();
        //发送消息到队列中
        channel.exchangeDeclare(TOPIC, BuiltinExchangeType.DIRECT, true);

        System.out.println("begin to send the messages!");
        long count = 0;
        while (count < 100) {

            for (int i = 0; i < 20; i++) {
                String routingKey = String.valueOf(i);
                channel.basicPublish(RabbitMQProducer.TOPIC,
                        RabbitMQProducer.ROUTING_KEY_PREFIX + routingKey,
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes("UTF-8"));
            }
            count++;
            Thread.sleep(1);
            System.out.println("current count :" + count);
        }
        System.out.println("close to send the messages!");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
