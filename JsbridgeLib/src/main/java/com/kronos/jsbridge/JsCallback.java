package com.kronos.jsbridge;

import org.json.JSONObject;

/**
 * Created by zhangyang on 16/3/16.
 */
public interface JsCallback {
    void onCallBack(JsBridge view, String function, JSONObject args);

    void setCallBackId(String callBackId);

    String getCallBackId();
}
