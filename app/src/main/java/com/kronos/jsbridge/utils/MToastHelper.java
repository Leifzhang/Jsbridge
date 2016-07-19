package com.kronos.jsbridge.utils;

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

  /*  public static void showToast(String message, int duration, int icon,
                                 int gravity) {
        if (message != null && !message.equalsIgnoreCase("")) {
            long time = System.currentTimeMillis();
            if (!message.equalsIgnoreCase(lastToast) || Math.abs(time - lastToastTime) > TimeMills) {
                View view = LayoutInflater.from(CoreApplication.getApplication()).inflate(
                        R.layout.view_krons_toast, null);
                ((TextView) view.findViewById(R.id.title_tv)).setText(message);
                if (icon != 0) {
                    ((ImageView) view.findViewById(R.id.icon_iv))
                            .setImageResource(icon);
                    view.findViewById(R.id.icon_iv)
                            .setVisibility(View.VISIBLE);
                }
                Toast toast = new Toast(CoreApplication.getApplication());
                toast.setView(view);
                if (gravity == Gravity.TOP) {
                    toast.setGravity(gravity, 0, 0);
                } else {
                    toast.setGravity(gravity, 0, 35);
                }
                toast.setDuration(duration);
                toast.show();
                lastToast = message;
                lastToastTime = System.currentTimeMillis();
            }
        }
    }*/

    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

}
