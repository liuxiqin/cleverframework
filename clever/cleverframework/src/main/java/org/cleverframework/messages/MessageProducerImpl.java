package org.cleverframework.messages;


import com.rabbitmq.client.*;
import org.cleverframework.infrastructure.serializes.BinarySerializer;
import org.cleverframework.infrastructure.serializes.BinarySerializerImpl;

/**
 * Created by cass02 on 2017/4/2.
 */
public class MessageProducerImpl implements MessageProducer {

    private BinarySerializer binarySerializer = new BinarySerializerImpl();


    public void send(MessageWrapper messageWrapper) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("123456");
        factory.setPort(5672);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送消息到队列中
        channel.exchangeDeclare(messageWrapper.getTopic(), BuiltinExchangeType.DIRECT, true);

        byte[] messageBytes = binarySerializer.serialize(messageWrapper);

        channel.basicPublish(messageWrapper.getTopic(),
                messageWrapper.getRoutingKey(),
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                messageBytes);

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
