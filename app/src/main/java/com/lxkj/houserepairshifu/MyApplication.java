package com.lxkj.houserepairshifu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.multidex.MultiDexApplication;

import com.lxkj.houserepairshifu.app.util.SharedPreferencesUtil;
import com.lxkj.houserepairshifu.app.util.ToastUtil;
import com.lxkj.houserepairshifu.app.util.abLog;


/**
 * Created by Slingge on 2017/1/24 0024.
 */

public class MyApplication extends MultiDexApplication {

    public static String uId = "";
    public static boolean isLogin = false;
    public static Context CONTEXT;

    private static MyApplication myApplication;

    public static String province, city, district,address;//定位地址


    public static final String Url = "http://120.27.10.241:8080/workService/service.action?";//正式
//    public static final String Url = "http://116.255.239.201:8080/appointService/service.action?";//测试

    String json = "{\"cmd\":\"getMsg\"" + "}";
// String json = "{\"cmd\":\"upPrize\",\"prizeId\":\"" + prizeId  + "\",\"userNme\":\"" + MyApplication.getUserName() + "\"}";


    public static String CameraPath = Environment.getExternalStorageDirectory().getPath() + "/com.lxkj.loanthrough/";

    public static MyApplication getInstance() {
        // if语句下是不会走的，Application本身已单例
        if (myApplication == null) {
            synchronized (MyApplication.class) {
                if (myApplication == null) {
                    myApplication = new MyApplication();
                }
            }
        }
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        abLog.E = true;
        CONTEXT = getApplicationContext();
        myApplication = this;
//        ImageLoaderUtil.configImageLoader(CONTEXT);
        isLogin = SharedPreferencesUtil.getSharePreBoolean(CONTEXT, "isLogin");

//        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this);     		// 初始化 JPush

//        UMShareAPI.get(this);
//        PlatformConfig.setWeixin("wx4216c376600ad4ff", "dd81644b17ffb2965911b48a13e233e2");
//        PlatformConfig.setQQZone("1106149976", "ofmWch3mF9OAki2z");
    }


    /**
     * 检查是否已经登录 true 已登录
     * @return
     */
    public static boolean isLogined() {
        return !(uId.equals("")) && isLogin;
    }

    /**
     * 是否登陆提示
     */
    public static boolean isLoginToa() {
        boolean b = !(uId.equals("")) && isLogin;
        if (b) {
            return true;
        } else {
            ToastUtil.showToast("请登录");
            return false;
        }
    }


    /**
     * 通过类名启动Activity
     *
     * @param targetClass
     */
    public static void openActivity(Context context, Class<?> targetClass) {
        openActivity(context, targetClass, null);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param targetClass
     * @param extras
     */
    public static void openActivity(Context context, Class<?> targetClass,
                                    Bundle extras) {
        Intent intent = new Intent(context, targetClass);
        if (extras != null) {
            intent.putExtras(extras);
        }
        context.startActivity(intent);
    }

    public static void openActivityForResult(Activity activity,
                                             Class<?> targetClass, Bundle extras, int requestCode) {
        Intent intent = new Intent(activity, targetClass);
        if (extras != null) {
            intent.putExtras(extras);
        }
        activity.startActivityForResult(intent, requestCode);
    }


    /**
     * Fragment中无效
     */
    public static void openActivityForResult(Activity activity,
                                             Class<?> targetClass, int requestCode) {
        openActivityForResult(activity, targetClass, null, requestCode);
    }

    public static Context getContext() {
        return CONTEXT;
    }


    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}
