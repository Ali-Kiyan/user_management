package com.alikn.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestampe;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestampe) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestampe = timestampe;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestampe() {
        return timestampe;
    }
}
