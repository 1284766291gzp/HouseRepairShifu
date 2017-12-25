package com.lxkj.houserepairshifu.app.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.adapter.MyFragmentPagerAdapter;
import com.lxkj.houserepairshifu.app.ui.mine.MineFragment;
import com.lxkj.houserepairshifu.app.ui.order.TabOrderFragment;
import com.lxkj.houserepairshifu.app.util.AppManager;
import com.lxkj.houserepairshifu.app.util.StatusBarUtil;
import com.lxkj.houserepairshifu.app.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    public CustomViewPager viewPager;
    private TextView tv_title;
    private RelativeLayout rl;
    private ImageView iv_back;

    public static boolean isForeground = false;
//    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        init();
        initvViewPager();
//        registerMessageReceiver();

    }


    private void init() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_back = (ImageView) findViewById(R.id.image_back);
        iv_back.setVisibility(View.INVISIBLE);
        rl = (RelativeLayout) findViewById(R.id.rl);

        RadioButton rb1 = (RadioButton) findViewById(R.id.rb_1);
        rb1.setChecked(true);
        rl.setVisibility(View.GONE);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        rl.setVisibility(View.GONE);
                        viewPager.setCurrentItem(0);
                        StatusBarUtil.setColorNoTranslucent(MainActivity.this, getResources().getColor(R.color.AsukaColor));
                        break;
                    case R.id.rb_2:
                        rl.setVisibility(View.VISIBLE);
                        rl.setBackgroundColor(getResources().getColor(R.color.color_2508767));
                        GoneRightImage();
                        tv_title.setText("全部订单");
                        tv_title.setTextColor(getResources().getColor(R.color.colorWhite));
                        viewPager.setCurrentItem(1);
                        StatusBarUtil.setColorNoTranslucent(MainActivity.this, getResources().getColor(R.color.color_2508767));
                        break;
                    case R.id.rb_3:
                        rl.setVisibility(View.VISIBLE);
                        rl.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                        tv_title.setText("我的");
                        tv_title.setTextColor(getResources().getColor(R.color.colorBlack));
                        viewPager.setCurrentItem(2);
                        StatusBarUtil.setColorNoTranslucent(MainActivity.this, getResources().getColor(R.color.colorWhite));
                        break;
                    case R.id.rb_4:
                        rl.setVisibility(View.VISIBLE);
                        rl.setBackgroundColor(getResources().getColor(R.color.color_2508767));
                        tv_title.setText("个人中心");
                        tv_title.setTextColor(getResources().getColor(R.color.colorWhite));
                        viewPager.setCurrentItem(3);
                        StatusBarUtil.setColorNoTranslucent(MainActivity.this, getResources().getColor(R.color.color_2508767));
                        break;
                }
            }
        });
    }


    private void initvViewPager() {
        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        List<Fragment> list = new ArrayList<>();
        list.add(new TabOrderFragment());
        list.add(new TabOrderFragment());
        list.add(new TabOrderFragment());
        list.add(new MineFragment());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
    }


    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                exitTime = System.currentTimeMillis();
            } else {
                new AppManager().finishAllActivity();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }



//    public void registerMessageReceiver() {
//        mMessageReceiver = new MessageReceiver();
//        IntentFilter filter = new IntentFilter();
//        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
//        filter.addAction(MESSAGE_RECEIVED_ACTION);
//        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
//    }


//    public class MessageReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            try {
//                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
//                    String messge = intent.getStringExtra(KEY_MESSAGE);
//                    String extras = intent.getStringExtra(KEY_EXTRAS);
//                    StringBuilder showMsg = new StringBuilder();
//                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
//                    if (!ExampleUtil.isEmpty(extras)) {
//                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
//                    }
////                    setCostomMsg(showMsg.toString());
//                }
//            } catch (Exception e){
//            }
//        }
//    }

}
