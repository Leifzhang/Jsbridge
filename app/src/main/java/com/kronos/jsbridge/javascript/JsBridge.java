package com.kronos.jsbridge.javascript;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by zhangyang on 16/3/15.
 */
public class JsBridge {

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case INVOKE:
                    try {
                        handlerCallback(msg.getData());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
            }
            return false;
        }
    });

    private static final String BridgeName = "__YutaJsBridge";
    private HashMap<String, CustomCallBack> callbacks;
    private static final int INVOKE = 0;
    private WebView webView;

    public JsBridge(WebView webView, JsMethodManager methodManager) {
        this.webView = webView;
        callbacks = new HashMap<>();
        methodManager.initMethod(webView.getContext(), callbacks);
        webView.addJavascriptInterface(new Js(), BridgeName);
    }

    public void loadJavaScipt(String callbackid, String json) {
        webView.loadUrl(CallbackToJs.getJavaScipt(callbackid, json));
    }

    public void loadError(String functionName, String json) {
        webView.loadUrl(CallbackToJs.getJavaScipt(callbacks.get(functionName).getCallBackId(), json));
    }

    private class Js {
        @JavascriptInterface
        public void invoke(String name, String args) throws Exception {
            Message msg = Message.obtain();
            msg.what = INVOKE;
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("args", args);
            msg.setData(bundle);
            handler.sendMessage(msg);
        }
    }


    private void handlerCallback(Bundle bundle) throws Exception {
        String method = bundle.getString("name");
        String[] nameSpaces = method.split("\\.");
        if (nameSpaces.length < 3 && !TextUtils.equals("Yuta", nameSpaces[0]))
            return;
        String args = bundle.getString("args");
        String methodName = nameSpaces[1];
        if (callbacks.containsKey(methodName)) {
            JSONObject argsObject = new JSONObject(args);
            callbacks.get(methodName).setCallBackId(argsObject.optString("callbackId"));
            callbacks.get(methodName).onCallBack(webView, nameSpaces[2], argsObject);
        }
    }

}
