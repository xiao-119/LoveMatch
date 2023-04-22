package com.ll.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private String message;
    private String code;

    public Result() {
        this.code = "0";
    }

    public Result(T data) {
        if (data == null) {
            this.code = "0";
        } else {
            this.code = "0";
            this.data = data;
        }
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
