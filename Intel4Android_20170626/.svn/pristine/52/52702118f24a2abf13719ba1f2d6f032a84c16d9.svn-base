package com.gagakj.intel4android.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.base.TaskStatusAdapter;
import com.gagakj.intel4android.base.BaseActivity;
import com.gagakj.intel4android.bean.FragmentInfo;
import com.gagakj.intel4android.fragment.GCItemFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

public class TaskStatusGcActivity extends BaseActivity  implements  View.OnClickListener{
    private int current_pager ;
    private String[] tag_name_array ;
    private ArrayList<FragmentInfo> fragmentInfoArrayList ;
    private SmartTabLayout viewPagerTab ;
    private ViewPager viewPager ;
    private LayoutInflater inflater ;
    private LinearLayout linear_back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_status_layout);
        initView();
        initValidata();
        initListener();
    }

    @Override
    public void initView() {
        super.initView();
        linear_back = $(R.id.linear_back);
        inflater = LayoutInflater.from(TaskStatusGcActivity.this);
        fragmentInfoArrayList = new ArrayList<>();
        viewPager = (ViewPager)findViewById(R.id.viewpages);
        viewPagerTab = (SmartTabLayout)findViewById(R.id.smart_tab);
    }
    @Override
    public void initValidata() {
        super.initValidata();
        current_pager = getIntent().getIntExtra("viewpager", 0);
        tag_name_array = getResources().getStringArray(R.array.titletab);
        for(int i = 0  ; i < tag_name_array.length ; i++){
            FragmentInfo info ;
            if(i == 0){
                info = new FragmentInfo(GCItemFragment.newInstance(1), tag_name_array[i]);
            }else if(i == 1){
                info = new FragmentInfo(GCItemFragment.newInstance(2) , tag_name_array[i]);
            }else{
                info = new FragmentInfo(GCItemFragment.newInstance(3), tag_name_array[i]);
            }
            fragmentInfoArrayList.add(info);
        }
        TaskStatusAdapter taskStatusAdapter = new TaskStatusAdapter(getSupportFragmentManager() , fragmentInfoArrayList);
        viewPager.setAdapter(taskStatusAdapter);
        viewPager.setCurrentItem(current_pager);
        viewPagerTab.setViewPager(viewPager);

    }
    @Override
    public void initListener() {
        super.initListener();
        linear_back.setOnClickListener(this);
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
