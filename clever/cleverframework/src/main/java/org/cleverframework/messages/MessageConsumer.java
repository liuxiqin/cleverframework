package org.cleverframework.messages;

/**
 * Created by cass02 on 2017/4/15.
 */
public interface MessageConsumer {

    void start() throws Exception;

    void close() throws Exception;

    String getName();
}
