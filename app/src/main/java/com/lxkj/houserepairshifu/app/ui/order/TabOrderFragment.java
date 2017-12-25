package com.lxkj.houserepairshifu.app.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lxkj.houserepairshifu.R;
import com.lxkj.houserepairshifu.app.ui.BaseFragment;


/**
 * 底部 订单
 * Created by Administrator on 2017/4/24 0024.
 */

public class TabOrderFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_order, container, false);
        init(view);
        return view;
    }



    private void init(View view) {



    }


    @Override
    public void loadData() {

//        onRefresh = 0;
//        if (qiangWorkList.size() == 0) {
//            getQiangWork(nowPage);
//        }
    }

//    private void getQiangWork(int page) {
//        if (isFirst) {
//            ProgressDialogs.showProgressDialog(getActivity(), "");
//            isFirst = false;
//        }
//        String json = "{\"cmd\":\"getGrabWorkList\",\"uid\":\"" + MyApplication.uId + "\",\"nowPage\":\"" + page + "\"}";
//        OkHttpUtils.post().url(MyApplication.Url).addParams("json", json).build().execute(new StrCallback() {
//            @Override
//            public void onResponse(String response, int id) {
//                super.onResponse(response, id);
//                QiangWorkBean bean = new Gson().fromJson(response, QiangWorkBean.class);
//                if (bean.result.equals("0")) {
//                    if (bean.totalPage!=null) {
//                        totalPage = Integer.parseInt(bean.totalPage);
//                    }
//                    if (bean.grabWorkLists!=null) {
//                        qiangWorkList.addAll(bean.grabWorkLists);
//                    }
//                    if (QiangWorkFragment.this.qiangWorkList.size() == 0 || QiangWorkFragment.this.totalPage == 1) {
//                        recyclerView.noMoreLoading();
//                    }
//                    if (onRefresh == 1) {
//                        recyclerView.refreshComplete();
//                    } else if (onRefresh == 2) {
//                        recyclerView.loadMoreComplete();
//                    }
//
//                    mAdapter.notifyDataSetChanged();
//                } else {
//                    ToastUtil.showToast(bean.resultNote);
//                }
//            }
//        });
//    }







}
