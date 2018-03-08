package com.jianyuyouhun.typechoapi.controller;

public enum RestResult {
    RESULT_DATA_OK(200, "RESULT_DATA_OK"),
    RESULT_DATA_EMPTY(201, "RESULT_DATA_EMPTY"),
    RESULT_ACCESS_DENIED(202, "RESULT_ACCESS_DENIED"),
    RESULT_SYS_ERROR(203, "RESULT_SYS_ERROR"),
    RESULT_USER_NOT_EXIST(101, "USER_NOT_EXIST"),
    RESULT_PWD_NOT_MATCH(102, "PWD_NOT_MATCH");
    protected int code;
    protected String message;
    RestResult(int code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
