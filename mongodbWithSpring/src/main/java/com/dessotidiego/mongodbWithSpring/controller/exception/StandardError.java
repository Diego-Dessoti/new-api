package com.dessotidiego.mongodbWithSpring.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private Long timestammp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Long timestammp, Integer status, String error, String message, String path) {
        this.timestammp = timestammp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestammp() {
        return timestammp;
    }

    public void setTimestammp(Long timestammp) {
        this.timestammp = timestammp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
