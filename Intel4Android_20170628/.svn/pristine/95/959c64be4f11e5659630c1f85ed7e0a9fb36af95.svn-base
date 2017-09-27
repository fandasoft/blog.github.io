package com.gagakj.intel4android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.base.TaskStatusAdapter;
import com.gagakj.intel4android.base.BaseActivity;
import com.gagakj.intel4android.bean.FragmentInfo;
import com.gagakj.intel4android.fragment.OLTItemInfoFragment;
import com.gagakj.intel4android.fragment.OLTTestFragment;
import com.gagakj.intel4android.network.model.OltInfoListResponse;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * 当前类注释:OLT详细信息
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.ui
 * 作者：江清清 on 2017/6/8 20:37
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class OLTInfoFrameActivity extends BaseActivity implements View.OnClickListener{

    private String[] tag_name_array ;
    private ArrayList<FragmentInfo> fragmentInfoArrayList ;
    private SmartTabLayout viewPagerTab ;
    private ViewPager viewPager ;
    private LayoutInflater inflater ;
    private ImageView img_back ;

    private Intent mIntent;
    private OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean;//具体OLT信息，其中包含基本信息，挂测列表信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olt_info_frame_layout);
        mIntent = getIntent();
        initView();
        initValidata();
        initListener();
        bindData();
    }

    @Override
    public void initView() {
        super.initView();
        img_back = $(R.id.img_back);
        inflater = LayoutInflater.from(this);
        fragmentInfoArrayList = new ArrayList<>();
        viewPager = (ViewPager)findViewById(R.id.viewpages);
        viewPagerTab = (SmartTabLayout)findViewById(R.id.smart_tab);
    }

    @Override
    public void initValidata() {
        super.initValidata();
        bizOLtInfoListBean = (OltInfoListResponse.ResultsBean.BizOltGcInfoListBean)mIntent.getSerializableExtra("olt_info");

        tag_name_array = getResources().getStringArray(R.array.olt_test_titletab);
        for(int i = 0  ; i < tag_name_array.length ; i++){
            FragmentInfo info ;
            if(i == 0){
                info = new FragmentInfo(OLTItemInfoFragment.newInstance(bizOLtInfoListBean), tag_name_array[i]);
            }else{
                info = new FragmentInfo(OLTTestFragment.newInstance(bizOLtInfoListBean), tag_name_array[i]);
            }
            fragmentInfoArrayList.add(info);
        }
        TaskStatusAdapter taskStatusAdapter = new TaskStatusAdapter(getSupportFragmentManager() , fragmentInfoArrayList);
        viewPager.setAdapter(taskStatusAdapter);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public void initListener() {
        super.initListener();
        img_back.setOnClickListener(this);
    }

    @Override
    public void bindData() {
        super.bindData();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.img_back :
                finish(this);
                break;
            default:
                break;
        }
    }

}
