package org.alinuswe.exceptions;



import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("java:S1948")
public class ApplicationException extends RuntimeException  {

    private HttpResponseStatus httpStatus;
    private List<String> errors;
    private Object data;

    private Integer StatusCode;

    public ApplicationException(String message) {
        this(HttpResponseStatus.BAD_REQUEST, message);
    }

    public ApplicationException(HttpResponseStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null, null);
    }


    public ApplicationException(HttpResponseStatus httpStatus, String message, List<String> errors, Integer StatusCode, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
        this.StatusCode = StatusCode;
    }

    public HttpResponseStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpResponseStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(Integer StatusCode) {
        this.StatusCode = StatusCode;
    }
}
