package com.gagakj.intel4android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.CNKFragmentPagerAdapter;
import com.gagakj.intel4android.base.BaseActivity;
import com.gagakj.intel4android.fragment.ApprovalHistoryFragment;
import com.gagakj.intel4android.fragment.EngineerInfoFragment;
import com.gagakj.intel4android.fragment.ProInforFragment;
import com.gagakj.intel4android.network.model.AlreadyMattersResponse;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.network.model.RecTodoListsMattersResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:任务详情 其中承载工程信息，专业信息，处理历史
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.ui
 * 作者：江清清 on 2017/6/8 20:05
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class TaskInformationActivity extends BaseActivity implements View.OnClickListener{
    private String[] tag_name_array ;
    private LinearLayout linear_back;
    private TextView info_title;
    private LinearLayout linear_approval;

    private Intent mIntent;
    private int type;


    private String taskId;

    private TabLayout tab_layout;
    private ViewPager info_viewpager;
    private List<Fragment> fragments;
    private CNKFragmentPagerAdapter mPagerAdater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olt_test_detail_layout);
        mIntent = getIntent();
        type = mIntent.getIntExtra("type",0);
        taskId = mIntent.getStringExtra("taskId");
        initView();
        initValidata();
        initListener();
        bindData();
    }

    @Override
    public void initView() {
        super.initView();
        info_title = $(R.id.info_title);
        info_title.setText("工单信息");
        linear_back = $(R.id.linear_back);
        info_viewpager = (ViewPager)findViewById(R.id.viewpages);
        tab_layout=(TabLayout)this.findViewById(R.id.tab_layout);
        linear_approval = $(R.id.linear_approval);
        if(type == 2){
            linear_approval.setVisibility(View.VISIBLE);
        }else{
            linear_approval.setVisibility(View.GONE);
        }
    }

    @Override
    public void initValidata() {
        super.initValidata();
//        if(type == 1){
//            recTodoListMattersModel = (RecTodoListsMattersResponse.ResultsBean)getIntent().getSerializableExtra("rec");
//        }else if(type == 2){
//            pendingMattersModel = (PendingMattersResponse.ResultsBean)getIntent().getSerializableExtra("pending");
//        }else if(type == 3){
//            alreadyMattersModel = (AlreadyMattersResponse.ResultsBean)getIntent().getSerializableExtra("already");
//        }

        tag_name_array = getResources().getStringArray(R.array.info_titletab);
        fragments = new ArrayList<>();
        for(int i = 0  ; i < tag_name_array.length ; i++){
            if(i == 0){
                fragments.add(EngineerInfoFragment.newInstance(taskId));
            }else if(i == 1){
                fragments.add(ProInforFragment.newInstance(taskId));
            }else{
                fragments.add(ApprovalHistoryFragment.newInstance(taskId));
            }
        }
        //创建Fragment的 ViewPager 自定义适配器
        mPagerAdater=new CNKFragmentPagerAdapter(getSupportFragmentManager());
        //设置显示的标题
        mPagerAdater.setTitles(tag_name_array);
        //设置需要进行滑动的页面Fragment
        mPagerAdater.setFragments(fragments);

        info_viewpager.setAdapter(mPagerAdater);
        tab_layout.setupWithViewPager(info_viewpager);

        //设置Tablayout
        //设置TabLayout模式 -该使用Tab数量比较多的情况
        tab_layout.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    public void initListener() {
        super.initListener();
        linear_back.setOnClickListener(this);
    }

    @Override
    public void bindData() {
        super.bindData();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_back :
                finish(this);
                break;
            default:
                break;
        }
    }
}
