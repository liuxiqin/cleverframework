package org.cleverframework.samples;

import com.rabbitmq.client.ConnectionFactory;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by cass02 on 2017/4/21.
 */
public class ActiveMQQueueConsumer implements MessageConsumer {

    private ActiveMQConnectionInfo connectionInfo;

    private String queueName;

    private Function<String, Boolean> consumer;

    public ActiveMQQueueConsumer(ActiveMQConnectionInfo connectionInfo, String queueName,Function<String, Boolean> received) {

    }

    public void start() {

//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, activeMQUrl);
//
//        try {
//
//            connection = (ActiveMQConnection) connectionFactory.createConnection();
//
//            ((ActiveMQConnection) connection).addTransportListener(new ClientTransportListener());
//
//            RedeliveryPolicy policy = ((ActiveMQConnection) connection).getRedeliveryPolicy();
//
//            // 设置重试策略
//            policy.setInitialRedeliveryDelay(2000);
//            policy.setRedeliveryDelay(2000);
//            policy.setBackOffMultiplier(2);
//            policy.setUseExponentialBackOff(true);
//            policy.setMaximumRedeliveries(6);
//
//            connection.start();
//            logger.debug("message connect success-->{}", connection);
//            Session session = connection.createSession(false, ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);
//
//            Destination destination = session.createQueue(queueName);
//
//            MessageConsumer messageConsumer = session.createConsumer(destination);
//
//            while (isActive) {
//
//                Message message = messageConsumer.receive(5000);
//
//                if (message == null) {
//                    Thread.sleep(1);
//                    continue;
//                }
//
//                TextMessage textMessage = (TextMessage) message;
//
//                String messageBody = textMessage.getText();
//
//                MessageWrapper wrapper = JsonUtils.deserialize(messageBody, MessageWrapper.class);
//
//                MessageResult result = MessageDispatcher.dispatch(wrapper);
//
//                if (result.getSucceed())
//                    message.acknowledge();
//                else
//                    session.recover();
//
//                Thread.sleep(1);
//            }
//        } catch (JMSException e) {
//            try {
//                connection.close();
//            } catch (JMSException e1) {
//                e1.printStackTrace();
//                logger.error("关闭连接失败-->{}", e1);
//            }
//            logger.error("activemq disconnected-->{}", e);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e1) {
//                logger.error("thread InterruptedException-->{}", e1);
//            }
//            listener();
//        } catch (InterruptedException e) {
//            logger.error("thread InterruptedException-->{}", e);
//        }
    }

    public void stop() {

    }

    public void run() {

    }
}
