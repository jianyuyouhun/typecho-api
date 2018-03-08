package com.jianyuyouhun.typechoapi.controller;

import com.jianyuyouhun.typechoapi.utils.json.JsonUtil;
import org.json.JSONObject;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 控制器基类
 */
public abstract class RestBaseController {

    protected JSONObject buildResult(RestResult restResult, Object object) {
        if (object == null) {
            return buildDefaultJson(restResult);
        } else if (object instanceof List) {
            return build(restResult, (List<Object>) object);
        } else {
            return build(restResult, object);
        }
    }

    private JSONObject buildDefaultJson(@NotNull RestResult restResult) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", restResult.code);
        jsonObject.put("message", restResult.message);
        return jsonObject;
    }

    private JSONObject build(@NotNull RestResult restResult, Object object) {
        return buildDefaultJson(restResult)
                .put("data", JsonUtil.toJSONObject(object));
    }

    private JSONObject build(@NotNull RestResult restResult, List<Object> list) {
        return buildDefaultJson(restResult)
                .put("list", JsonUtil.toJSONArray(list));
    }
}
