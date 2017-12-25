package com.lxkj.houserepairshifu.app.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.util.AppManager;
import com.lxkj.houserepairshifu.app.util.ProgressDialogs;
import com.lxkj.houserepairshifu.app.util.StatusBarUtil;


/**
 * Created by Slingge on 2017/1/24 0024.
 */

public class BaseActivity extends AppCompatActivity {

    private ImageView image_right,image_back;
    private TextView tv_title;
    private RelativeLayout rl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.addActivity(this);
        if (android.os.Build.VERSION.SDK_INT > 19) {
            StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.AsukaColor));
        }
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    protected void initTitle(String title) {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(title);
        ImageView iv_back = (ImageView) findViewById(R.id.image_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    protected void setTitleBg() {
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setTextColor(getResources().getColor(R.color.colorBlack));
        image_back=(ImageView)findViewById(R.id.image_back);
        image_back.setImageResource(R.drawable.fanhui01);
        rl=(RelativeLayout)findViewById(R.id.rl);
        rl.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }


    protected void GoneRightImage() {
        image_right = (ImageView) findViewById(R.id.image_right);
        image_right.setVisibility(View.INVISIBLE);
    }


    protected void GoneBackImage() {
        image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setVisibility(View.INVISIBLE);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ProgressDialogs.dismissDialog();
    }

}
