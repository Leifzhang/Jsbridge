package com.kronos.jsbridge.jsfunction;

import android.os.Bundle;
import android.webkit.WebView;

import com.kronos.jsbridge.javascript.CustomCallBack;

import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by zhangyang on 16/3/22.
 */
public class CameraCallBack extends CustomCallBack {
    public CameraCallBack() {
        this.callbackFunctionName = "Camera";
    }

    public static final int REQUEST_CAMERA = 0;
    public static final int REQUEST_ALBUM = 1;
    public static final int REQUEST_CROP = 2;

    @Override
    public void onCallBack(final WebView view, String function, JSONObject args) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = args.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = args.optString(key);
            bundle.putString(key, value);
        }
        /*bundle.putBoolean(CameraActivity.USE_FRONT_CAMERA, TextUtils.equals(args.optString("cameraDirection"), "1"));
        GlobalContext.getInstance().setArgs(bundle);
        CommentPickerDialog dialog = new CommentPickerDialog();
        dialog.setArguments(bundle);
        dialog.setDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("message", "fail");
                    JSONObject resultObject = new JSONObject();
                    jsonObject.put("results", resultObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                view.loadUrl(CallbackToJs.getJavaScipt(getCallBackId(), jsonObject.toString()));
            }
        });
        try {
            int type = args.getInt("sourceType");
            switch (type) {
                case 0:
                    dialog.show(getActivity().getSupportFragmentManager(), "");
                    break;
                case 1:
                    ActivityHelper.startActivityForResult(getActivity(), CameraActivity.class, CameraCallBack.REQUEST_CAMERA, bundle);
                    break;
                case 2:
                    ActivityHelper.startActivityForResult(getActivity(), Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, CameraCallBack.REQUEST_ALBUM);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            Log.e("TAG", e.toString());
            e.printStackTrace();
        }*/
    }
}
