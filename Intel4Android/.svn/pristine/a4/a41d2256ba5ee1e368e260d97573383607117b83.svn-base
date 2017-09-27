package com.gagakj.intel4android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseFragment;

/**
 * 当前类注释:专业信息展示Fragment
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/24 21:30
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class ProInforFragment extends BaseFragment {
    private View mView;
    private static final String KEY = "ProInforFragment";
    private String taskId;
    public static ProInforFragment newInstance(String taskId){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,taskId);
        ProInforFragment fragment=new ProInforFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            taskId = bundle.getString(KEY);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
           mView =  inflater.inflate(R.layout.pro_info_fragment_layout , container , false);
            initView();
            initValidata();
            initListener();
            bindData();
        }
        return mView;
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initValidata() {
        super.initValidata();
    }

    @Override
    public void initListener() {
        super.initListener();
    }

    @Override
    public void bindData() {
        super.bindData();
    }
}
