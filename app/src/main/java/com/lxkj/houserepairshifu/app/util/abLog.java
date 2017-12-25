package com.lxkj.houserepairshifu.app.util;

import android.util.Log;

import com.lxkj.houserepairshifu.MyApplication;


/**
 * Created by Slingge on 2017/2/21 0021.
 */

public class abLog {

    public static Boolean E = true;


    public static void e(String tag, String text) {
        if (E) {
            if (text.length() > 4000) {
                int count = 0;
                for (int i = 0; i < text.length(); i += 4000) {
                    count++;
                    if (i + 4000 < text.length()) {
                        Log.e(tag + count, text.substring(i, i + 4000));
                    } else {
                        Log.e(tag + count, text.substring(i, text.length()));
                    }
                }
            } else
                Log.e(tag, text);
        }
    }

    public static void e2(String text) {
        if (E) {
            if (text.length() > 4000) {
                int count=0;
                for (int i = 0; i < text.length(); i += 4000) {
                    count++;
                    if (i + 4000 < text.length()) {
                        Log.e(MyApplication.CONTEXT.getClass().getSimpleName() + count, text.substring(i, i + 4000));
                    } else {
                        Log.e(MyApplication.CONTEXT.getClass().getSimpleName() + count, text.substring(i, text.length()));
                    }
                }
            } else
                Log.e(MyApplication.CONTEXT.getClass().getSimpleName(), text);
        }
    }

}
