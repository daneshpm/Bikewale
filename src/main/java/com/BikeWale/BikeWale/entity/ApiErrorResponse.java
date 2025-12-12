package com.BikeWale.BikeWale.entity;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private int statusCode;
    private String error;
    private String message;
    private LocalDateTime timestamp;
    private String path;

    public ApiErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
