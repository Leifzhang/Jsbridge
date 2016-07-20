package com.kronos.sample.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhangyang on 16/1/13.
 */
public class MToastHelper {
    private static long TimeMills = 3 * 1000;

    public static void toast(Context context, String content) {
        showToast(context, content);
    }


    private static String lastToast = "";
    private static long lastToastTime;


    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

}
