package com.gagakj.intel4android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.base.TaskBoxAdapter;
import com.gagakj.intel4android.base.BaseFragment;
import com.gagakj.intel4android.bean.TaskBoxListInfo;
import com.gagakj.intel4android.common.Constants;

import java.util.ArrayList;

/**
 * Created by zhujiaqi on 2017/5/27.
 */

public class UnderWayTaskFragment extends BaseFragment {

    private View viewlayout;
    private ListView lv_list_task;
    private TaskBoxAdapter adapter ;
    private ArrayList<TaskBoxListInfo> taskBoxListInfos ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewlayout = inflater.inflate(R.layout.underway_task_fragment_layout , container , false);
        return viewlayout ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initValidata();
    }

    public void initView(){
        lv_list_task = (ListView) viewlayout.findViewById(R.id.lv_list_task);
        taskBoxListInfos = new ArrayList<>() ;
    }

    public void initValidata(){
        for (int i = 0  ; i < 10  ; i++){
            TaskBoxListInfo taskBoskListinfo = new TaskBoxListInfo("线路专业开工流程" , "张伟" , "2017/01/12");
            taskBoxListInfos.add(taskBoskListinfo);
        }

        adapter = new TaskBoxAdapter(getActivity() , taskBoxListInfos , Constants.UNDERWAY_TASK);
        lv_list_task.setAdapter(adapter);

    }
}
