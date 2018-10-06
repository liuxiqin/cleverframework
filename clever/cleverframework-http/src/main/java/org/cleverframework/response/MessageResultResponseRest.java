package org.cleverframework.response;

import org.cleverframework.infrastructure.exceptions.SendMessageHandlerResultException;
import org.cleverframework.messages.MessageHandlerResult;
import org.cleverframework.messages.RemoteEndPoint;
import org.cleverframework.messages.channels.MessageReplyChannel;
import org.cleverframework.messages.channels.MessageResultSendChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消息结果发送和结果通道
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 12:41
 */
@RestController
public class MessageResultResponseRest implements MessageResultSendChannel {

    @Autowired
    private MessageReplyChannel replyChannel;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void send(MessageHandlerResult handlerResult, RemoteEndPoint endPoint) {

        final String url = String.format("http://%s:%s/messages/results/receive", endPoint.getIpAddress(), endPoint.getPort());

        ResponseEntity<HttpResult> result = restTemplate.postForEntity(url, handlerResult, HttpResult.class);

        if (null == result || HttpStatus.OK != result.getStatusCode() || HttpStatus.OK.value() != result.getBody().getHttpCode()) {

            throw new SendMessageHandlerResultException(handlerResult, endPoint);
        }
    }

    /**
     * 接受消息结果
     *
     * @return
     */
    @RequestMapping(value = "/messages/results/receive", method = RequestMethod.POST)
    public ResponseEntity<HttpResult> receive(@RequestBody MessageHandlerResult result) {

        replyChannel.reply(result);

        return ResponseEntity.ok(HttpResult.ok());
    }


}
