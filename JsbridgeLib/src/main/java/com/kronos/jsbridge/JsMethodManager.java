package com.kronos.jsbridge;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by zhangyang on 16/3/17.
 */
public interface JsMethodManager {
    void initMethod(Context context, HashMap<String, CustomCallBack> map);
}
