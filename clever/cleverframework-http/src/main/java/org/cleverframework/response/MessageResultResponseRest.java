package org.cleverframework.response;

import org.cleverframework.infrastructure.exceptions.SendMessageHandlerResultException;
import org.cleverframework.messages.MessageHandlerResult;
import org.cleverframework.messages.MessageResultContext;
import org.cleverframework.messages.channels.MessageReplyChannel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;

/**
 * 消息结果发送和结果通道
 *
 * @Author: xiqin.liu
 * @Date: 2018/9/30 12:41
 */
@RestController
public class MessageResultResponseRest {

    private MessageReplyChannel replyChannel;

    private RestTemplate restTemplate;

    public void send(MessageResultContext context) {

        final String url = String.format("http://%s:%s/messages/results/receive", context.getRemoteEndPoint().getIpaddress(), context.getRemoteEndPoint().getPort());

        ResponseEntity<HttpResult> result = restTemplate.postForEntity(url, context.getResult(), HttpResult.class);

        if (null == result || HttpStatus.OK != result.getStatusCode() || HttpStatus.OK.value() != result.getBody().getHttpCode()) {

            throw new SendMessageHandlerResultException(context);
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
