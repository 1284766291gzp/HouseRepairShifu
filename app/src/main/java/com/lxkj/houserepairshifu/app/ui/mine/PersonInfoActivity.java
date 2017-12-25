package com.lxkj.houserepairshifu.app.ui.mine;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lxkj.houserepairshifu.MyApplication;
import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.ui.BaseActivity;
import com.lxkj.houserepairshifu.app.util.StatusBarUtil;
import com.lxkj.houserepairshifu.app.view.CircleImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;


/**
 * Created by Administrator on 2017/5/10 0010.
 * 换绑手机号
 */

public class PersonInfoActivity extends BaseActivity implements View.OnClickListener {

    private CircleImageView userIcon;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        initTitle("个人资料");
        initView();
    }

    private void initView() {
        String name=getIntent().getStringExtra("name");
        String pos=getIntent().getStringExtra("pos");
        String url=getIntent().getStringExtra("url");
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorWhite));
        GoneRightImage();
        setTitleBg();

//        userIcon=(CircleImageView)findViewById(R.id.img_usericon);
//
//        TextView txt_name=(TextView)findViewById(R.id.txt_name);
//        TextView txt_position=(TextView)findViewById(R.id.txt_position);
//        txt_name.setText(name);
//        txt_position.setText(pos);
//        ImageLoader.getInstance().displayImage(url, userIcon, ImageFileUtil.getImageLoaderOptions(R.drawable.touxiang_wode));
//
//
//
//        RelativeLayout rl_usericon=(RelativeLayout)findViewById(R.id.rl_usericon);
//        rl_usericon.setOnClickListener(this);
        RelativeLayout rl_change_bind_phone=(RelativeLayout)findViewById(R.id.rl_change_bind_phone);
        rl_change_bind_phone.setOnClickListener(this);
//        RelativeLayout rl_modify_login_pswd=(RelativeLayout)findViewById(R.id.rl_modify_login_pswd);
//        rl_modify_login_pswd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.rl_usericon:
//                if (PermissionUtil.ApplyPermissionAlbum(this)) {
//                    toPhotoPicker();
//                }
//                break;
            case R.id.rl_change_bind_phone:
                MyApplication.openActivity(this, ChangeBindPhoneActivity.class);
                break;
//            case R.id.rl_modify_login_pswd:
//                MyApplication.openActivity(this, ModifyLoginPswdActivity.class);
//                break;
        }
    }



//    private void toPhotoPicker() {
//        PhotoPickerIntent intent = new PhotoPickerIntent(this);
//        intent.setPhotoCount(1);
//        intent.setShowCamera(true);
//        startActivityForResult(intent, 0);
//    }
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == 0) {
//            if (data != null) {
//                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
//                if (photos.size() > 0) {
//                    CameraUtils.startPhotoZoom(this, Uri.fromFile(new File(photos.get(0))));
//                }
//            }
//        }
//        if (resultCode == RESULT_OK && requestCode == 1) {
//            Bundle extras = data.getExtras();
//            Bitmap bitmap = extras.getParcelable("data");
//            uploaderHeader(bitmap);
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            toPhotoPicker();
//        } else {
//            PermissionsDialog.dialog(this, "需要访问内存卡和拍照权限");
//        }
//    }
//
//
//    private void uploaderHeader(final Bitmap bitmap) {
//        ProgressDialogs.showProgressDialog(this, "上传中...");
//        String json = "{\"cmd\":\"updateUserIcon\",\"uid\":\"" + MyApplication.uId + "\",\"userIcon\":\"" + ImageFileUtil.bitmaptoString(bitmap) + "\"}";
//        OkHttpUtils.post().url(MyApplication.Url).addParams("json", json).build().execute(new StrCallback() {
//            @Override
//            public void onResponse(String response, int id) {
//                super.onResponse(response, id);
//                try {
//                    JSONObject obj = new JSONObject(response);
//                    if (obj.getString("result").equals("0")) {
//                        userIcon.setImageBitmap(bitmap);
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
