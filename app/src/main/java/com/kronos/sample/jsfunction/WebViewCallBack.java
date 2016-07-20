package com.kronos.sample.jsfunction;

import android.text.TextUtils;
import android.webkit.WebView;

import com.kronos.jsbridge.CustomCallBack;
import com.kronos.jsbridge.JsBridge;

import org.json.JSONObject;

/**
 * Created by zhangyang on 16/3/22.
 */
public class WebViewCallBack extends CustomCallBack {
    public WebViewCallBack() {
        this.callbackFunctionName = "WebView";
    }

    @Override
    public void onCallBack(JsBridge jsBridge, String function, JSONObject args) {
        WebView view = jsBridge.getWebView();
        if (TextUtils.equals(function, "open")) {
            open(view, args);
        }
        if (TextUtils.equals(function, "close")) {
            close(view, args);
        }
        if (TextUtils.equals(function, "closeAll")) {
            closeAll(view, args);
        }
        if (TextUtils.equals(function, "load")) {
            load(view, args);
        }
    }

    private void open(WebView view, JSONObject args) {
        String url = args.optString("url");
        //   RouterConstans.open(url, getActivity());
    }

    private void close(WebView view, JSONObject args) {
        getActivity().finish();
    }

    private void closeAll(WebView view, JSONObject args) {

    }

    private void load(WebView view, JSONObject args) {
        String url = args.optString("url");
        view.loadUrl(url);
    }
}
