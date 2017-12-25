package com.lxkj.houserepairshifu.app.ui.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lxkj.houserepairshifu.MyApplication;
import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.ui.BaseFragment;
import com.lxkj.houserepairshifu.app.view.CircleImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * 我的
 * Created by Administrator on 2017/4/24 0024.
 */

public class MineFragment extends BaseFragment implements  View.OnClickListener {

    private CircleImageView img_usreicon;
    private TextView txt_name,txt_position;

    private String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        init(view);
        return view;
    }



    private void init(View view) {
//        img_usreicon=(CircleImageView)view.findViewById(R.id.img_usreicon);
//        txt_name=(TextView)view.findViewById(R.id.txt_name);
//        txt_position=(TextView)view.findViewById(R.id.txt_position);
//
        RelativeLayout rl_userinfo=(RelativeLayout)view.findViewById(R.id.rl_userinfo);
        rl_userinfo.setOnClickListener(this);
        RelativeLayout rl_modify_login_pswd=(RelativeLayout)view.findViewById(R.id.rl_modify_login_pswd);
        rl_modify_login_pswd.setOnClickListener(this);
//        RelativeLayout  rl_my_getlist=(RelativeLayout) view.findViewById(R.id.rl_my_getlist);
//        rl_my_getlist.setOnClickListener(this);
//        RelativeLayout rl_my_raffle=(RelativeLayout)view.findViewById(R.id.rl_my_raffle);
//        rl_my_raffle.setOnClickListener(this);
//        RelativeLayout rl_my_collect=(RelativeLayout)view.findViewById(R.id.rl_my_collect);
//        rl_my_collect.setOnClickListener(this);
//        RelativeLayout rl_setting=(RelativeLayout)view.findViewById(R.id.rl_setting);
//        rl_setting.setOnClickListener(this);



    }

    @Override
    public void onResume() {
        super.onResume();
//        getUserInfo();
    }

    @Override
    public void loadData() {
//        getUserInfo();
    }


    private String getPosition(String position)
    {
        String strPosition = "";
        if (position.equals("0"))
        {
            strPosition="员工";
        }else if (position.equals("1"))
        {
            strPosition="部门负责人";
        }else if (position.equals("2"))
        {
            strPosition="副经理";
        }else if (position.equals("3"))
        {
            strPosition="经理";
        }
        return strPosition;
    }


//    private void getUserInfo()
//    {
//        ProgressDialogs.showProgressDialog(getActivity(), "");
//        Map<String, String> params = new HashMap<>();
//        String json = "{\"cmd\":\"getMineMessage\",\"uid\":\"" + MyApplication.uId + "\"}";
//        abLog.e("个人信息/...........", json);
//        params.put("json", json);
//        OkHttpUtils.post().params(params).url(MyApplication.Url).build()
//                .execute(new StrCallback() {
//                             @Override
//                             public void onResponse(String response, int id) {
//                                 super.onResponse(response, id);
//                                 try {
//                                     JSONObject obj = new JSONObject(response);
//                                     if (obj.getString("result").equals("0")) {
//
//                                         url=obj.getString("userIcon");
//                                         ImageLoader.getInstance().displayImage(obj.getString("userIcon"), img_usreicon, ImageFileUtil.getImageLoaderOptions(R.drawable.touxiang_wode));
//                                         if (!TextUtils.isEmpty(obj.getString("userName"))) {
//                                             txt_name.setText(obj.getString("userName"));
//                                         } else {
//                                             txt_name.setText(SharedPreferencesUtil.getSharePreStr(getActivity(), "userNickname"));
//                                         }
//                                         String position=obj.getString("userPosition");
//
//                                         if (!TextUtils.isEmpty(position)) {
//                                             txt_position.setText(getPosition(position));
//                                         } else {
//                                             position=SharedPreferencesUtil.getSharePreStr(getActivity(), "userPosition");
//                                             txt_position.setText(getPosition(position));
//                                         }
//                                         SharedPreferencesUtil.putSharePre(getActivity(), "userIcon", obj.getString("userIcon"));
//                                         SharedPreferencesUtil.putSharePre(getActivity(), "auditAuthority", obj.getString("auditAuthority"));
//                                     } else {
//                                         ToastUtil.showToast(obj.getString("resultNote"));
//                                     }
//                                 } catch (JSONException e) {
//                                     e.printStackTrace();
//                                 }
//                             }
//                         }
//                );
//    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_userinfo://编辑资料
                MyApplication.openActivity(getActivity(), PersonInfoActivity.class);

//                Bundle bundle = new Bundle();
//                if (MyApplication.isLogined()) {
//                    bundle.putString("name",txt_name.getText().toString());
//                    bundle.putString("pos",txt_position.getText().toString());
//                    bundle.putString("url",url);
//                    MyApplication.openActivity(getActivity(), EditUserinfoActivity.class, bundle);
//                } else {
//                    MyApplication.openActivity(getActivity(), LoginActivity.class);
//                }

                break;
            case R.id.rl_modify_login_pswd://修改密码
                MyApplication.openActivity(getActivity(), ModifyLoginPswdActivity.class);
                break;
//            case R.id.rl_my_getlist://我的抢单
//                MyApplication.openActivity(getActivity(), MyQiangWorkActivity.class);
//                break;
//            case R.id.rl_my_raffle://我的抽奖
//                MyApplication.openActivity(getActivity(), MyRaffleActivity.class);
//                break;
//            case R.id.rl_my_collect://我的收藏
//                MyApplication.openActivity(getActivity(), MyCollectActivity.class);
//                break;
//            case R.id.rl_setting://设置
//                MyApplication.openActivity(getActivity(), SettingActivity.class);
//                break;

        }
    }





    @Override
    public void onDestroy() {
        super.onDestroy();
//        AnimUtil.endAnim();
    }


}
