package com.kronos.sample.jsfunction;

import com.kronos.jsbridge.CustomCallBack;
import com.kronos.jsbridge.JsBridge;
import com.kronos.sample.utils.MToastHelper;

import org.json.JSONObject;

/**
 * Created by zhangyang on 16/3/22.
 */
public class ShareCallBack extends CustomCallBack {
    public ShareCallBack() {
        this.callbackFunctionName = "Share";
    }

    @Override
    public void onCallBack(JsBridge jsBridge, String function, JSONObject args) {
        MToastHelper.toast(getActivity(), "开启分享模式");
    }
}
