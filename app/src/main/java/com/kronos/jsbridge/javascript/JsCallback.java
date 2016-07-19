package com.kronos.jsbridge.javascript;

import android.webkit.WebView;

import org.json.JSONObject;

/**
 * Created by zhangyang on 16/3/16.
 */
public interface JsCallback {
    void onCallBack(WebView view, String function, JSONObject args);

    void setCallBackId(String callBackId);

    String getCallBackId();
}
