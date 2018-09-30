package org.cleverframework.response;

import org.cleverframework.messages.MessageHandlerResult;
import org.springframework.http.HttpStatus;

/**
 * @Author: xiqin.liu
 * @Date: 2018/9/30 13:12
 */
public class HttpResult {

    private int httpCode;

    private String message;


    public HttpResult() {

    }

    public HttpResult(int httpCode, String message) {

        this.httpCode = httpCode;
        this.message = message;
    }

    public static HttpResult ok() {

        return new HttpResult(200, "OK");
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
