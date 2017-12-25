package com.lxkj.houserepairshifu.app.ui.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.ui.BaseActivity;
import com.lxkj.houserepairshifu.app.util.StatusBarUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/10 0010.
 * 换绑手机号
 */

public class ChangeBindPhoneActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_phone;
    private EditText et_verification;

    private String VCode;
//    private TimerUtil timerUtil;
//    private SMSVerificationCodeRequest smsVerificationCodeRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bind_phone);
        initTitle("换绑手机");
        initView();
    }

    private void initView() {
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorWhite));
        GoneRightImage();
        setTitleBg();
//        et_phone = (EditText) findViewById(R.id.et_phone);
//        et_verification = (EditText) findViewById(R.id.et_verification);
//
//        TextView tv_get_ver = (TextView) findViewById(R.id.tv_get_ver);
//        TextView tv_change = (TextView) findViewById(R.id.tv_change);
//        tv_get_ver.setOnClickListener(this);
//        tv_change.setOnClickListener(this);
//
//        smsVerificationCodeRequest=new SMSVerificationCodeRequest(this);
//        smsVerificationCodeRequest.setSMSVerificationCodeCallBack(this);
//        timerUtil = new TimerUtil(tv_get_ver);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.tv_get_ver:
//                String phone = AbStrUtil.etTostr(et_phone);
//                if(TextUtils.isEmpty(phone)){
//                    ToastUtil.showToast("请输入手机号");
//                    return;
//                }
//                smsVerificationCodeRequest.sendSMS(this, phone, "3");
//                timerUtil.timersStart();
//                break;
//            case R.id.tv_change:
//                phone = AbStrUtil.etTostr(et_phone);
//                if (TextUtils.isEmpty(phone)) {
//                    ToastUtil.showToast("手机号不能为空");
//                    return;
//                }
//                if (phone.length()!=11)
//                {
//                    ToastUtil.showToast("手机号吗不正确");
//                    return;
//                }
//                String code = AbStrUtil.etTostr(et_verification);
//                if (!code.equals(VCode)) {
//                    ToastUtil.showToast("验证码错误");
//                    return;
//                }
//                change(phone);
//                break;
        }
    }

//    @Override
//    public void sMSVerificationCode(String verificationCode) {
//        VCode=verificationCode;
//    }

//    private void change(String phone) {
//
//        Map<String, String> params = new HashMap<>();
//        String json = "{\"cmd\":\"updatePhoneNum\",\"uid\":\"" + MyApplication.uId + "\"," + "\"userPhone\":\"" + phone + "\"}";
//        params.put("json", json);
//        OkHttpUtils.post().url(MyApplication.Url).params(params).build().execute(new StrCallback() {
//            @Override
//            public void onResponse(String response, int id) {
//                super.onResponse(response, id);
//                try {
//                    JSONObject obj = new JSONObject(response);
//                    if (obj.getString("result").equals("0")) {
//                        ToastUtil.showToast("手机号更换成功");
//                        finish();
//                    } else {
//                        ToastUtil.showToast(obj.getString("resultNote"));
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
