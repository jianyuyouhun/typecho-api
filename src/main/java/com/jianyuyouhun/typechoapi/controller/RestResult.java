package com.jianyuyouhun.typechoapi.controller;

import com.jianyuyouhun.typechoapi.utils.json.JsonUtil;
import org.json.JSONObject;

import java.util.List;

public enum RestResult {
    RESULT_DATA_OK(200, "RESULT_DATA_OK"),
    RESULT_DATA_EMPTY(201, "RESULT_DATA_EMPTY"),
    RESULT_ACCESS_DENIED(202, "RESULT_ACCESS_DENIED"),
    RESULT_SYS_ERROR(203, "RESULT_SYS_ERROR"),
    RESULT_USER_NOT_EXIST(101, "USER_NOT_EXIST"),
    RESULT_PWD_NOT_MATCH(102, "PWD_NOT_MATCH");
    private int code;
    private String message;
    RestResult(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static JSONObject buildDefaultJson(RestResult restResult) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", restResult.code);
        jsonObject.put("message", restResult.message);
        return jsonObject;
    }

    public static JSONObject build(RestResult restResult, Object object) {
        return buildDefaultJson(restResult)
                .put("data", JsonUtil.toJSONObject(object));
    }

    public static JSONObject build(RestResult restResult, List<Object> list) {
        return buildDefaultJson(restResult)
                .put("list", JsonUtil.toJSONArray(list));
    }
}
