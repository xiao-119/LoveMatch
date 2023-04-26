package com.ll.demo.exception;

public class ParseException extends RuntimeException {
    private String errorCode;

    public ParseException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public static void throwParseException(String errMsg) {
        throw new ParseException("101", errMsg);
    }

    public static void throwParseException(String errCode, String errMsg) {
        throw new ParseException(errCode, errMsg);
    }
}