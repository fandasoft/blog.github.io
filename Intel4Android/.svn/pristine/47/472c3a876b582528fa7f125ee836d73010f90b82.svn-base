package com.gagakj.intel4android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.base.CommonAdapter;
import com.gagakj.intel4android.adapter.base.ViewHolder;
import com.gagakj.intel4android.application.IntelApplication;
import com.gagakj.intel4android.base.BaseFragment;
import com.gagakj.intel4android.common.RequestAction;
import com.gagakj.intel4android.network.http.HTTPHelper;
import com.gagakj.intel4android.network.http.ResultSubscriber;
import com.gagakj.intel4android.network.model.AlreadyMattersGcResponse;
import com.gagakj.intel4android.network.model.AlreadyMattersResponse;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.PendingMattersGcResponse;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.network.model.RecTodoListGcResponse;
import com.gagakj.intel4android.network.model.RecTodoListsMattersResponse;
import com.gagakj.intel4android.ui.OLTTestDetailActivity;
import com.gagakj.intel4android.ui.OLTTestDetailGcActivity;
import com.gagakj.intel4android.utils.DateUtil;
import com.gagakj.intel4android.utils.SharedPreferencesHelper;
import com.gagakj.intel4android.utils.SharedPreferencesTag;

import java.util.HashMap;
import java.util.List;

/**
 * 当前类注释:挂测列表的Fragment(待办，在办，已办)
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/6 17:24
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class GCItemFragment extends BaseFragment implements ResultSubscriber.OnResultListener,AdapterView.OnItemClickListener {
    private static final String KEY = "GCItemFragment";
    private int type = 0;

    private View mView;
    private ListView lv_list_task;
    private HashMap<String,String> req_map;
    private String userId;
    private Intent mIntent;

    //待办列表事项
    private List<RecTodoListGcResponse.ResultsBean> recTodoListsMatters;
    //在办列表事项
    private List<PendingMattersGcResponse.ResultsBean> pendingMatters;
    //已办列表事项
    private List<AlreadyMattersGcResponse.ResultsBean> alreadyMatters;

    private CommonAdapter<RecTodoListGcResponse.ResultsBean> recTodoListMattersAdapter;
    private CommonAdapter<PendingMattersGcResponse.ResultsBean> pendingMattersAdapter;
    private CommonAdapter<AlreadyMattersGcResponse.ResultsBean> alreadtMattersAdapter;


    public static GCItemFragment newInstance(int type){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,type);
        GCItemFragment fragment=new GCItemFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            type=(int)bundle.getSerializable(KEY);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            mView = inflater.inflate(R.layout.wating_task_fragment_layout , container , false);
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
        lv_list_task = $(R.id.lv_list_task);
    }

    @Override
    public void initValidata() {
        super.initValidata();
        userId = SharedPreferencesHelper.getInstance(IntelApplication.getInstance()).getStringValue(SharedPreferencesTag.KEY_USERID);
        //发送请求
        req_map= new HashMap<>();
        req_map.put("userId", userId);
        if(type == 1){
            HTTPHelper.getInstance().recTodoListMattersGcReq(RecTodoListGcResponse.class,req_map, RequestAction.ACTION_RECTODOLISTMATTERS_GC,this);
        }else if(type == 2){
            HTTPHelper.getInstance().pendingMattersGcReq(PendingMattersGcResponse.class,req_map, RequestAction.ACTION_PENDING_MATTERS_GC,this);
        }else if(type == 3){
            HTTPHelper.getInstance().alreadyMattersGcReq(AlreadyMattersGcResponse.class,req_map, RequestAction.ACTION_ALREADYMATTERS_GC,this);
        }
    }

    @Override
    public void initListener() {
        super.initListener();
        lv_list_task.setOnItemClickListener(this);
    }

    @Override
    public void bindData() {
        super.bindData();

    }

    @Nullable
    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void onStart(int requestType) {

    }

    @Override
    public void onCompleted(int requestType) {

    }

    @Override
    public void onError(int requestType) {

    }

    @Override
    public void onNext(IModel t, int requestType) {
        if(requestType == RequestAction.ACTION_RECTODOLISTMATTERS_GC){
            RecTodoListGcResponse recTodoListGcResponse = (RecTodoListGcResponse)t;
            if(recTodoListGcResponse.getTotalCounts() > 0 && recTodoListGcResponse.getResults()!=null){
                renderRecTodoList(recTodoListGcResponse.getResults());
            }
        }else if(requestType == RequestAction.ACTION_ALREADYMATTERS_GC){
            AlreadyMattersGcResponse alreadyMattersGcResponse = (AlreadyMattersGcResponse)t;
            if(alreadyMattersGcResponse.getTotalCounts() > 0 && alreadyMattersGcResponse.getResults()!=null){
                renderAlreayTaskList(alreadyMattersGcResponse.getResults());
            }
        }else if(requestType == RequestAction.ACTION_PENDING_MATTERS_GC){
            PendingMattersGcResponse pendingMattersGcResponse = (PendingMattersGcResponse) t;
            if(pendingMattersGcResponse.getTotalCounts() > 0 && (pendingMatters = pendingMattersGcResponse.getResults())!=null){
                renderPendingTaskList(pendingMatters);
            }
        }
    }

    /**
     * 进行刷新待办任务列表
     */
    private void renderRecTodoList(List<RecTodoListGcResponse.ResultsBean> resultsBeens){
        recTodoListMattersAdapter = new CommonAdapter<RecTodoListGcResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, RecTodoListGcResponse.ResultsBean item) {
                //显示领取按钮
                TextView tv_receive = holder.getView(R.id.tv_receive);
                tv_receive.setVisibility(View.VISIBLE);
                holder.setText(R.id.tv_taskbox_name,item.getSubject())
                        .setText(R.id.tv_worker_name,item.getCreator())
                        .setText(R.id.tv_time, DateUtil.getTimeConversion(item.getCreateTime().getTime()));
            }
        };
        lv_list_task.setAdapter(recTodoListMattersAdapter);
    }


    /**
     * 在办
     * @param resultsBeens
     */
    private void renderPendingTaskList(List<PendingMattersGcResponse.ResultsBean> resultsBeens){
        pendingMattersAdapter = new CommonAdapter<PendingMattersGcResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, PendingMattersGcResponse.ResultsBean item) {
                //显示领取按钮
                TextView tv_receive = holder.getView(R.id.tv_receive);
                tv_receive.setVisibility(View.INVISIBLE);
                holder.setText(R.id.tv_taskbox_name,item.getSubject())
                        .setText(R.id.tv_worker_name,item.getCreator())
                        .setText(R.id.tv_time, DateUtil.getTimeConversion(item.getCreateTime().getTime()));
            }
        };
        lv_list_task.setAdapter(pendingMattersAdapter);
    }

    /**
     * 进行刷新已办任务列表
     * @param resultsBeens
     */
    private void renderAlreayTaskList(List<AlreadyMattersGcResponse.ResultsBean> resultsBeens){
        alreadtMattersAdapter = new CommonAdapter<AlreadyMattersGcResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, AlreadyMattersGcResponse.ResultsBean item) {
                //显示领取按钮
                TextView tv_receive = holder.getView(R.id.tv_receive);
                tv_receive.setVisibility(View.INVISIBLE);
                holder.setText(R.id.tv_taskbox_name,item.getSubject())
                        .setText(R.id.tv_worker_name,item.getCreator())
                        .setText(R.id.tv_time, DateUtil.getTimeConversion(item.getCreatetime().getTime()));
            }
        };
        lv_list_task.setAdapter(alreadtMattersAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(type == 1){

        }else if(type == 2){
            mIntent = new Intent(getActivity(), OLTTestDetailGcActivity.class);
            mIntent.putExtra("olt",pendingMatters.get(position));
            mIntent.putExtra("type",2);
            startNewActivityNoramlWithIntent(mIntent);
        }else if(type == 3){

        }
    }
}
