package org.cleverframework.samples;

/**
 * Created by cass02 on 2017/4/21.
 */
public interface MessageConsumer extends Runnable {

    void start();
    void stop();
}
