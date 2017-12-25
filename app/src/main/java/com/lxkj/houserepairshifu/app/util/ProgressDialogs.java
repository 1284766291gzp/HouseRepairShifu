package com.lxkj.houserepairshifu.app.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxkj.houserepairshifu.R;


/**
 * 类说明: 自定义ProgressDialog
 */
public class ProgressDialogs {

    public static Dialog proDialog;

    public static void dismissDialog() {
        if (proDialog != null) {
            proDialog.dismiss();
            proDialog = null;
        }
    }


    public static void showProgressDialog(Context context, String msg) {
        if (proDialog == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
            RelativeLayout cv = (RelativeLayout) v.findViewById(R.id.cv);// 加载布局

            TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
            ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
            Animation animation = AnimationUtils.loadAnimation(
                    context, R.anim.progress_dialog_rotate);
            spaceshipImage.setAnimation(animation);

            if (!TextUtils.isEmpty(msg)) {
                tipTextView.setText(msg);
            }

            if (Build.VERSION.SDK_INT > 19) {
                tipTextView.setTextColor(context.getResources().getColor(R.color.colorWhite));
            }
            proDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
            proDialog.show();
            proDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
            proDialog.setCancelable(true);// 可以用“返回键”
            proDialog.setContentView(cv, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));// 设置布局
        } else {
            if (proDialog.isShowing()) {
                proDialog.dismiss();
            }
            proDialog.show();
        }
    }

}
