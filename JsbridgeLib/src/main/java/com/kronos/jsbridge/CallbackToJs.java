package com.kronos.jsbridge;

/**
 * Created by zhangyang on 16/3/23.
 */
public class CallbackToJs {
    public static String getJavaScipt(String callbackid, String args) {
        return String.format("javascript:window.__YutaAppCallback(%s,%s)", callbackid, args);
    }

}
