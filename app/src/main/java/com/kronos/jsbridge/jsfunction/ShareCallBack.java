package com.kronos.jsbridge.jsfunction;

import android.webkit.WebView;

import com.kronos.jsbridge.javascript.CustomCallBack;
import com.kronos.jsbridge.utils.MToastHelper;

import org.json.JSONObject;

/**
 * Created by zhangyang on 16/3/22.
 */
public class ShareCallBack extends CustomCallBack {
    public ShareCallBack() {
        this.callbackFunctionName = "Share";
    }

    @Override
    public void onCallBack(WebView view, String function, JSONObject args) {
        MToastHelper.toast(view.getContext(), "开启分享模式");
    }
}
