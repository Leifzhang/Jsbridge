package com.kronos.jsbridge.jsfunction;

import android.text.TextUtils;
import android.webkit.WebView;

import com.kronos.jsbridge.javascript.CustomCallBack;

import org.json.JSONObject;

/**
 * Created by zhangyang on 16/3/22.
 */
public class WebViewCallBack extends CustomCallBack {
    public WebViewCallBack() {
        this.callbackFunctionName = "WebView";
    }

    @Override
    public void onCallBack(WebView view, String function, JSONObject args) {
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
