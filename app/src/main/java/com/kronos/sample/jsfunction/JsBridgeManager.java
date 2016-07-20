package com.kronos.sample.jsfunction;

import android.app.Activity;
import android.content.Context;

import com.kronos.jsbridge.CustomCallBack;
import com.kronos.jsbridge.JsMethodManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyang on 16/3/17.
 */
public class JsBridgeManager implements JsMethodManager {

    @Override
    public void initMethod(Context context, HashMap<String, CustomCallBack> map) {
        CameraCallBack camera = new CameraCallBack();
        map.put(camera.getCallbackFunctionName(), camera);
        WebViewCallBack openWebview = new WebViewCallBack();
        map.put(openWebview.getCallbackFunctionName(), openWebview);
        ShareCallBack share = new ShareCallBack();
        map.put(share.getCallbackFunctionName(), share);
        for (Map.Entry<String, CustomCallBack> entry : map.entrySet()) {
            entry.getValue().attach((Activity) context);
        }
    }
}
