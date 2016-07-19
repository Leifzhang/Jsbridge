package com.kronos.jsbridge.jsfunction;

import android.app.Activity;
import android.content.Intent;

import com.kronos.jsbridge.javascript.JsBridge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangyang on 16/4/12.
 */
public class CameraCallToJs {
    private JsBridge jsBridge;
    private String callbackFunctionName = "Camera";
    private Activity mActivity;

    public CameraCallToJs(Activity activity, JsBridge jsBridge) {
        this.jsBridge = jsBridge;
        this.mActivity = activity;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            onActivityError();
            return;
        }
        onActivityResult(requestCode, data);
    }


    private void onActivityResult(int requestCode, Intent data) {
       /* if (null != data && CameraCallBack.REQUEST_ALBUM == requestCode) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = mActivity.getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            if (cursor == null)
                return;
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bundle b = GlobalContext.getInstance().getArgs();
            b.putString("path", picturePath);
            b.putString("name", System.currentTimeMillis() + "");
            ActivityHelper.startActivityForResult(mActivity, PhotoCropActivity.class, CameraCallBack.REQUEST_CROP, b);
        }
        if (requestCode == CameraCallBack.REQUEST_CAMERA) {
            Bundle bundle = GlobalContext.getInstance().getArgs();
            bundle.putAll(data.getExtras());
            bundle.putString("name", System.currentTimeMillis() + "");
            ActivityHelper.startActivityForResult(mActivity, PhotoCropActivity.class, CameraCallBack.REQUEST_CROP, bundle);
        }
        if (requestCode == CameraCallBack.REQUEST_CROP) {
            final Bundle bundle = GlobalContext.getInstance().getArgs();
            bundle.putAll(data.getExtras());
            String file = data.getExtras().getString("path");
            int targetWidth = Integer.valueOf(bundle.getString("targetWidth", "0"));
            int targetHeight = Integer.valueOf(bundle.getString("targetHeight", "0"));
         //   targetWidth = targetHeight <= 0 ? SimpleTarget.SIZE_ORIGINAL : targetWidth;
         //   targetHeight = targetHeight <= 0 ? SimpleTarget.SIZE_ORIGINAL : targetHeight;
            try {
                ImageLoadManager.loadBitmap(file, mActivity, new SimpleResponseListener<Bitmap>() {
                    @Override
                    public void onComplete(Bitmap bitmap) {
                        testing(bundle, bitmap, jsBridge);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    private void onActivityError() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("message", "fail");
            JSONObject resultObject = new JSONObject();
            jsonObject.put("results", resultObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsBridge.loadError(callbackFunctionName, jsonObject.toString());
    }

    /*private static void testing(Bundle bundle, final Bitmap bitmap, JsBridge js) {
        final String callbackid = bundle.getString("callbackId");
        final String quality = bundle.getString("quality", "100");
        int q = Integer.valueOf(quality);
        String str = FileUtil.getBitmapBase64(bitmap, q);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("message", "success");
            JSONObject resultObject = new JSONObject();
            resultObject.put("data", str);
            jsonObject.put("results", resultObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        js.loadJavaScipt(callbackid, jsonObject.toString());
    }*/
}
