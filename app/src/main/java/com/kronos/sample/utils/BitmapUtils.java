package com.kronos.sample.utils;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by zhangyang on 16/7/20.
 */
public class BitmapUtils {
    public static String getBase64(byte[] bytes) {
        return new String(Base64.encode(bytes, Base64.DEFAULT));
    }

    public static byte[] Bitmap2Bytes(Bitmap bm, int quality) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        quality = quality > 100 ? 100 : quality;
        bm.compress(Bitmap.CompressFormat.PNG, quality, baos);
        return baos.toByteArray();
    }

    public static String getBitmapBase64(Bitmap bm, int quality) {
        return getBase64(Bitmap2Bytes(bm, quality));
    }
}
