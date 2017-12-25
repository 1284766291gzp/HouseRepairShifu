package com.lxkj.houserepairshifu.app.ui.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.ui.BaseActivity;
import com.lxkj.houserepairshifu.app.util.AbStrUtil;
import com.lxkj.houserepairshifu.app.util.StatusBarUtil;
import com.lxkj.houserepairshifu.app.util.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/10 0010.
 * 换绑手机号
 */

public class ModifyLoginPswdActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_old_pswd,et_new_pswd,et_again_new_pswd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pswd_pswd);
        initTitle("修改密码");
        initView();
    }

    private void initView() {
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorWhite));
        GoneRightImage();
        setTitleBg();

        et_old_pswd=(EditText)findViewById(R.id.et_old_pswd);
        et_new_pswd=(EditText)findViewById(R.id.et_new_pswd);
        et_again_new_pswd=(EditText)findViewById(R.id.et_again_new_pswd);

        TextView tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                String old_pswd = AbStrUtil.etTostr(et_old_pswd);
                if (TextUtils.isEmpty(old_pswd)) {
                    ToastUtil.showToast("请输入原密码");
                    return;
                }
                String new_pswd = AbStrUtil.etTostr(et_new_pswd);
                if (TextUtils.isEmpty(new_pswd)) {
                    ToastUtil.showToast("请输入新密码");
                    return;
                }
                String again_new_pswd = AbStrUtil.etTostr(et_again_new_pswd);
                if (TextUtils.isEmpty(new_pswd)) {
                    ToastUtil.showToast("请再次输入新密码");
                    return;
                }
                if (!new_pswd.equals(again_new_pswd))
                {
                    ToastUtil.showToast("两次输入密码不一致");
                    return;
                }
//                submit(old_pswd,new_pswd);
                break;
        }
    }

//    private void submit(String old_pswd,String new_pswd) {
//
//        Map<String, String> params = new HashMap<>();
//        String json = null;
//        try {
//            json = "{\"cmd\":\"updateLoginPassword\",\"uid\":\"" + MyApplication.uId + "\",\"oldPassword\":\"" + Md5Util.md5Encode(old_pswd)+ "\",\"newPassword\":\"" + Md5Util.md5Encode(new_pswd) + "\"}";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        params.put("json", json);
//        Log.e("json",json);
//        OkHttpUtils.post().url(MyApplication.Url).params(params).build().execute(new StrCallback() {
//            @Override
//            public void onResponse(String response, int id) {
//                super.onResponse(response, id);
//                try {
//                    JSONObject obj = new JSONObject(response);
//                    if (obj.getString("result").equals("0")) {
//                        ToastUtil.showToast(obj.getString("resultNote"));
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
