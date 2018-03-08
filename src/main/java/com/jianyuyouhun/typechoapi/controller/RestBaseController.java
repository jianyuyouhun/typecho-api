package com.jianyuyouhun.typechoapi.controller;

import org.json.JSONObject;

import java.util.List;

/**
 * 控制器基类
 */
public abstract class RestBaseController {

    protected JSONObject buildResult(RestResult restResult, Object object) {
        if (object == null) {
            return RestResult.buildDefaultJson(restResult);
        } else if (object instanceof List) {
            return RestResult.build(restResult, (List<Object>) object);
        } else {
            return RestResult.build(restResult, object);
        }
    }
}
