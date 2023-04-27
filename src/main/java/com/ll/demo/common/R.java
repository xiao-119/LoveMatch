package com.ll.demo.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private String message;
    private String code;

    public R() {
        this.code = "0";
    }

    private R(T data) {
        this.code = "0";
        this.message = "success";
        if (data != null) {
            this.data = data;
        }
    }

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static R<String> error(String msg) {
        return new R<>("-1", msg);
    }

    public static <T> R<T> success(T data) {
        return new R<>(data);
    }
}
