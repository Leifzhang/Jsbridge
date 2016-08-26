package com.kronos.sample.jsfunction;

import android.text.TextUtils;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.kronos.jsbridge.CustomCallBack;
import com.kronos.jsbridge.JsBridge;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Leif Zhang on 16/8/26.
 * Email leifzhanggithub@gmail.com
 */
public class LoadImageCallBack extends CustomCallBack {

    public LoadImageCallBack() {
        this.callbackFunctionName = "Image";
    }

    @Override
    public void onCallBack(JsBridge view, String function, JSONObject args) {
        if (TextUtils.equals(function, "loadImage")) {
            open(view, args);
        }
    }

    private void open(final JsBridge view, final JSONObject args) {
        final String url = args.optString("image");
        //   RouterConstans.open(url, getActivity());
        Observable.just(url).map(new Func1<String, File>() {
            @Override
            public File call(String s) {
                try {
                    return Glide.with(view.getWebView().getContext())
                            .load(s).downloadOnly(SimpleTarget.SIZE_ORIGINAL, SimpleTarget.SIZE_ORIGINAL).get();
                } catch (Exception e) {
                    throw Exceptions.propagate(e);
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<File>() {
            @Override
            public void call(File file) {
                Log.i("", "");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("message", "success");
                    JSONObject resultObject = new JSONObject();
                    String path = "file:///" + file.getAbsolutePath();
                    resultObject.put("data", path);
                    jsonObject.put("results", resultObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                view.loadJavaScript(args.optString("callbackId"), jsonObject.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }
}
