package org.cleverframework.messages;

import com.google.common.collect.Lists;

import java.util.List;

public class MessageConsumerContainer {

    private List<MessageConsumer> consumers = Lists.newArrayList();

    private ThreadGroup cconsumerThreadGroup = new ThreadGroup("clever consumer threads");

    private List<Thread> threads = Lists.newArrayList();

    public MessageConsumerContainer addConsumer(MessageConsumer consumer) {

        consumers.add(consumer);

        threads.add(new Thread(cconsumerThreadGroup, consumer, consumer.getName()));

        return this;
    }

    public void start() {

        if (consumers.isEmpty()) {
            return;
        }

        for (Thread thread : threads) {

            thread.setDaemon(true);

            thread.start();
        }
    }

    public void stop() {

        for (Thread thread : threads) {

            thread.interrupt();
        }
    }

}
