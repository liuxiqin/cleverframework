package org.cleverframework.samples;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017-04-03 .
 */
public class RabbitMQConsumer {

    private final static String TOPIC = "Seven.Tests";

    private final static String ROUTING_KEY_PREFIX = "Seven.Tests_command_";

    public final static ExecutorService threadPool = Executors.newFixedThreadPool(20);

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
       // RabbitMQConsumer.receiveMessage();
        System.out.println("Hello World!");
        System.out.println("class.getName():" + RabbitMQConsumer.class.getName());
        System.out.println("package.getName():" + RabbitMQConsumer.class.getPackage().getName());
    }

    private static void receiveMessage() throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("123456");
        factory.setPort(5672);
        factory.setRequestedHeartbeat(60);
        //创建一个新的连接
        Connection connection = factory.newConnection(RabbitMQConsumer.threadPool);
        //创建一个通道
        final Channel channel = connection.createChannel();

        connection.setId(UUID.randomUUID().toString());

        for (int i = 0; i < 100; i++) {
            Channel tempChannel = connection.createChannel();

            System.out.println("connection:" + connection.getId() + ",channel->" + tempChannel.toString());
        }

        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ " + new Date();
        //发送消息到队列中
        channel.exchangeDeclare(TOPIC, BuiltinExchangeType.DIRECT, true);

        System.out.println("begin to receive the messages!");

        for (int i = 0; i < 20; i++) {
            //持久化
            channel.queueDeclare(ROUTING_KEY_PREFIX + String.valueOf(i), true, false, false, null);
            channel.basicQos(1);
            channel.queueBind(ROUTING_KEY_PREFIX + String.valueOf(i), TOPIC, ROUTING_KEY_PREFIX + String.valueOf(i));
        }

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                try {
                    Thread.sleep(1000);
                    String message = new String(body, "UTF-8");
                    System.out.println("[x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                    channel.basicAck(envelope.getDeliveryTag(), true);
                }
                catch (Exception e){
                   e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            channel.basicConsume(ROUTING_KEY_PREFIX + String.valueOf(i), true, consumer);
        }

        System.out.println(Thread.getAllStackTraces());

        System.out.println("close to receive the messages!");

    }
}
