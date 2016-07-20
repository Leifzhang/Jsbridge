package com.kronos.sample.jsfunction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.kronos.jsbridge.CustomCallBack;
import com.kronos.jsbridge.JsBridge;
import com.kronos.sample.R;

import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by zhangyang on 16/3/22.
 */
public class CameraCallBack extends CustomCallBack {
    public CameraCallBack() {
        this.callbackFunctionName = "Camera";
    }

    @Override
    public void onCallBack(final JsBridge jsBridge, String function, JSONObject args) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = args.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = args.optString(key);
            bundle.putString(key, value);
        }
        Bitmap bitmap = BitmapFactory.decodeResource(jsBridge.getWebView().getResources(),
                R.mipmap.ic_launcher);
        CameraCallToJs.sendBitmap(bundle, bitmap, jsBridge);
    }
}
