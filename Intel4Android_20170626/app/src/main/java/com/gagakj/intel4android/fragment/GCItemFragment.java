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
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.PendingMattersGcResponse;
import com.gagakj.intel4android.network.model.RecTodoListGcResponse;
import com.gagakj.intel4android.network.model.RecTodoTaskResponse;
import com.gagakj.intel4android.network.model.RefuseToTaskResponse;
import com.gagakj.intel4android.ui.OLTTestDetailGcActivity;
import com.gagakj.intel4android.utils.DateUtil;
import com.gagakj.intel4android.utils.Log;
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
        reqData();
    }

    /**
     * 进行数据请求
     */
    private void reqData(){
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
        hideProgressDialog();
        showProgressDialog("数据加载失败!");
    }

    @Override
    public void onNext(IModel t, int requestType) {
        hideProgressDialog();
        if(requestType == RequestAction.ACTION_RECTODOLISTMATTERS_GC){
            RecTodoListGcResponse recTodoListGcResponse = (RecTodoListGcResponse)t;
            if(recTodoListGcResponse.getTotalCounts() > 0 && (recTodoListsMatters = recTodoListGcResponse.getResults())!=null){
                renderRecTodoList(recTodoListGcResponse.getResults());
            }
        }else if(requestType == RequestAction.ACTION_ALREADYMATTERS_GC){
            AlreadyMattersGcResponse alreadyMattersGcResponse = (AlreadyMattersGcResponse)t;
            if(alreadyMattersGcResponse.getTotalCounts() > 0 && (alreadyMatters = alreadyMattersGcResponse.getResults())!=null){
                renderAlreayTaskList(alreadyMattersGcResponse.getResults());
            }
        }else if(requestType == RequestAction.ACTION_PENDING_MATTERS_GC){
            PendingMattersGcResponse pendingMattersGcResponse = (PendingMattersGcResponse) t;
            if(pendingMattersGcResponse.getTotalCounts() > 0 && (pendingMatters = pendingMattersGcResponse.getResults())!=null){
                renderPendingTaskList(pendingMatters);
            }
        }else if(requestType == RequestAction.ACTION_REC_TODO_TASK){
            RecTodoTaskResponse recTodoTaskResponse = (RecTodoTaskResponse)t;
            if(recTodoTaskResponse.isSuccess()){
                reqData();
                showShortToast(recTodoTaskResponse.getMsg());

            }else{
                showShortToast(recTodoTaskResponse.getMsg());
            }
        }else if(requestType == RequestAction.ACTION_REFUSE_TODO_TASK){
            RefuseToTaskResponse refuseToTaskResponse = (RefuseToTaskResponse)t;
            if(refuseToTaskResponse.isSuccess()){
                reqData();
                showShortToast(refuseToTaskResponse.getMsg());

            }else{
                showShortToast(refuseToTaskResponse.getMsg());
            }
        }
    }

    /**
     * 进行刷新待办任务列表
     */
    private void renderRecTodoList(List<RecTodoListGcResponse.ResultsBean> resultsBeens){
        recTodoListMattersAdapter = new CommonAdapter<RecTodoListGcResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, final RecTodoListGcResponse.ResultsBean item) {
                //显示领取按钮
                TextView tv_receive = holder.getView(R.id.tv_receive);
                tv_receive.setVisibility(View.VISIBLE);
                holder.setText(R.id.tv_taskbox_name,item.getSubject())
                        .setText(R.id.tv_worker_name,item.getCreator())
                        .setText(R.id.tv_time, DateUtil.getTimeConversion(item.getCreateTime().getTime()));

                //点击领取按钮
                tv_receive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //taskId=xxx&instanceId=xxx&businessKey=xxx
                        HashMap<String,String> req_map = new HashMap<String, String>();
                        req_map.put("taskId",item.getId());
                        req_map.put("instanceId",item.getProcessInstanceId());
                        req_map.put("businessKey",item.getTaskDefinitionKey());
                        HTTPHelper.getInstance().recTodoTaskReq(RecTodoTaskResponse.class,req_map,RequestAction.ACTION_REC_TODO_TASK,GCItemFragment.this);
                        showProgressDialog("正在领取中");
                    }
                });
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
            public void convert(ViewHolder holder, final PendingMattersGcResponse.ResultsBean item) {
                //隐藏领取按钮
                TextView tv_receive = holder.getView(R.id.tv_receive);
                tv_receive.setVisibility(View.VISIBLE);
                tv_receive.setText("取消");
                holder.setText(R.id.tv_taskbox_name,item.getSubject())
                        .setText(R.id.tv_worker_name,item.getCreator())
                        .setText(R.id.tv_time, DateUtil.getTimeConversion(item.getCreateTime().getTime()));

                //点击取消按钮
                tv_receive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //taskId=10000010450311&instanceId=10000010450126
                        HashMap<String,String> req_map = new HashMap<String, String>();
                        req_map.put("taskId",item.getId());
                        req_map.put("instanceId",item.getProcessInstanceId());
                        HTTPHelper.getInstance().refuseTodoTaskReq(RefuseToTaskResponse.class,req_map,RequestAction.ACTION_REFUSE_TODO_TASK,GCItemFragment.this);
                        showProgressDialog("正在取消中");
                    }
                });
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
                //隐藏领取按钮
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
        mIntent = new Intent(getActivity(), OLTTestDetailGcActivity.class);
        if(type == 1){
            mIntent.putExtra("type",1);
            mIntent.putExtra("taskIdOrId",recTodoListsMatters.get(position).getId());
        }else if(type == 2){
            mIntent.putExtra("type",2);
            mIntent.putExtra("taskIdOrId",pendingMatters.get(position).getId());
        }else if(type == 3){
            mIntent.putExtra("type",3);
            mIntent.putExtra("taskIdOrId",alreadyMatters.get(position).getRunId());
        }
        startNewActivityNoramlWithIntent(mIntent);
    }
}
