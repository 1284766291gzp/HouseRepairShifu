package com.lxkj.houserepairshifu.app.util;

import android.widget.Toast;

import com.lxkj.houserepairshifu.MyApplication;


/**
 * 单例Toast
 */

public class ToastUtil {

    private static Toast mToast;

    public static void showToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text);
        mToast.show();
    }


    public static void showLongToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_LONG);
        }
        mToast.setText(text);
        mToast.show();
    }

}
