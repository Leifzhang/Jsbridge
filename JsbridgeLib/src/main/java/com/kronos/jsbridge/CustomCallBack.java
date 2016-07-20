package com.kronos.jsbridge;

import android.app.Activity;

/**
 * Created by zhangyang on 16/3/22.
 */
public abstract class CustomCallBack implements JsCallback {
    protected String callbackFunctionName;
    private Activity mActivity;
    private String callBackId;

    public void attach(Activity context) {
        this.mActivity = context;
    }

    public String getCallbackFunctionName() {
        return callbackFunctionName;
    }

    public Activity getActivity() {
        return mActivity;
    }

    @Override
    public void setCallBackId(String callBackId) {
        this.callBackId = callBackId;
    }

    @Override
    public String getCallBackId() {
        return callBackId;
    }
}
