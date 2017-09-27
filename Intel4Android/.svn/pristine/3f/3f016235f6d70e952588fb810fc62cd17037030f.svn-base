package com.gagakj.intel4android.fragment;

import android.app.Activity;
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
import com.gagakj.intel4android.network.model.AlreadyMattersResponse;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.network.model.RecTodoListsMattersResponse;
import com.gagakj.intel4android.network.model.RecTodoTaskResponse;
import com.gagakj.intel4android.network.model.RefuseToTaskResponse;
import com.gagakj.intel4android.ui.TaskInformationActivity;
import com.gagakj.intel4android.utils.DateUtil;
import com.gagakj.intel4android.utils.Log;
import com.gagakj.intel4android.utils.SharedPreferencesHelper;
import com.gagakj.intel4android.utils.SharedPreferencesTag;

import java.util.HashMap;
import java.util.List;

/**
 * 当前类注释:
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/6 17:24
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class ItemFragment extends BaseFragment implements ResultSubscriber.OnResultListener,AdapterView.OnItemClickListener {
    private static final String KEY = "ItemFragment";
    private int type = 0;

    private View mView;
    private ListView lv_list_task;
    private HashMap<String,String> req_map;
    private String userId;
    private Intent mIntent;
    private Activity mActivity;

    //待办列表事项
    private List<RecTodoListsMattersResponse.ResultsBean> recTodoListsMatters;
    //在办列表事项
    private List<PendingMattersResponse.ResultsBean> pendingMatters;
    //已办列表事项
    private List<AlreadyMattersResponse.ResultsBean> alreadyMatters;

    private CommonAdapter<RecTodoListsMattersResponse.ResultsBean> recTodoListMattersAdapter;
    private CommonAdapter<PendingMattersResponse.ResultsBean> pendingMattersAdapter;
    private CommonAdapter<AlreadyMattersResponse.ResultsBean> alreadtMattersAdapter;


    public static ItemFragment newInstance(int type){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,type);
        ItemFragment fragment=new ItemFragment();
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
     * 进行请求数据
     */
    private void reqData(){
        userId = SharedPreferencesHelper.getInstance(IntelApplication.getInstance()).getStringValue(SharedPreferencesTag.KEY_USERID);
        //发送请求
        req_map= new HashMap<>();
        req_map.put("userId", userId);
        if(type == 1){
            HTTPHelper.getInstance().recTodoListMattersReq(RecTodoListsMattersResponse.class,req_map, RequestAction.ACTION_RECTODOLISTMATTERS,this);
        }else if(type == 2){
            HTTPHelper.getInstance().pendingMattersReq(PendingMattersResponse.class,req_map, RequestAction.ACTION_PENDING_MATTERS,this);
        }else if(type == 3){
            HTTPHelper.getInstance().alreadyMattersReq(AlreadyMattersResponse.class,req_map, RequestAction.ACTION_ALREADYMATTERS,this);
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
        showShortToast("数据加载失败!");
    }

    @Override
    public void onNext(IModel t, int requestType) {
        hideProgressDialog();
        if(requestType == RequestAction.ACTION_RECTODOLISTMATTERS){
            RecTodoListsMattersResponse recTodoListsMattersResponse = (RecTodoListsMattersResponse)t;
            if(recTodoListsMattersResponse.getTotalCounts() > 0 &&(recTodoListsMatters = recTodoListsMattersResponse.getResults())!=null){
                renderRecTodoList(recTodoListsMattersResponse.getResults());
            }
        }else if(requestType == RequestAction.ACTION_ALREADYMATTERS){
            AlreadyMattersResponse alreadyMattersResponse = (AlreadyMattersResponse)t;
            if(alreadyMattersResponse.getTotalCounts() > 0 && (alreadyMatters = alreadyMattersResponse.getResults())!=null){
                renderAlreayTaskList(alreadyMattersResponse.getResults());
            }
        }else if(requestType == RequestAction.ACTION_PENDING_MATTERS){
            PendingMattersResponse pendingMattersResponse = (PendingMattersResponse) t;
            if(pendingMattersResponse.getTotalCounts() > 0 && (pendingMatters=pendingMattersResponse.getResults())!=null){
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
    private void renderRecTodoList(List<RecTodoListsMattersResponse.ResultsBean> resultsBeens){
        recTodoListMattersAdapter = new CommonAdapter<RecTodoListsMattersResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, final RecTodoListsMattersResponse.ResultsBean item) {
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
                        HTTPHelper.getInstance().recTodoTaskReq(RecTodoTaskResponse.class,req_map,RequestAction.ACTION_REC_TODO_TASK,ItemFragment.this);
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
    private void renderPendingTaskList(List<PendingMattersResponse.ResultsBean> resultsBeens){
        pendingMattersAdapter = new CommonAdapter<PendingMattersResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, final PendingMattersResponse.ResultsBean item) {
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
                        Log.d("zttjiangqq","taskId:"+item.getId());
                        Log.d("zttjiangqq","instanceId:"+item.getProcessInstanceId());
                        HashMap<String,String> req_map = new HashMap<String, String>();
                        req_map.put("taskId",item.getId());
                        req_map.put("instanceId",item.getProcessInstanceId());
                        HTTPHelper.getInstance().refuseTodoTaskReq(RefuseToTaskResponse.class,req_map,RequestAction.ACTION_REFUSE_TODO_TASK,ItemFragment.this);
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
    private void renderAlreayTaskList(List<AlreadyMattersResponse.ResultsBean> resultsBeens){
        alreadtMattersAdapter = new CommonAdapter<AlreadyMattersResponse.ResultsBean>(getActivity(),resultsBeens,R.layout.item_taskbox_list) {
            @Override
            public void convert(ViewHolder holder, AlreadyMattersResponse.ResultsBean item) {
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
        mIntent = new Intent(getActivity(), TaskInformationActivity.class);
        if(type == 1){
            mIntent.putExtra("type",1);
            //mIntent.putExtra("rec",recTodoListsMatters.get(position));
            mIntent.putExtra("taskId",recTodoListsMatters.get(position).getId());
        }else if(type == 2){
            mIntent.putExtra("type",2);
            //mIntent.putExtra("pending",pendingMatters.get(position));
            mIntent.putExtra("taskId",pendingMatters.get(position).getId());
        }else if(type == 3){
            mIntent.putExtra("type",3);
            //mIntent.putExtra("already",alreadyMatters.get(position));
            mIntent.putExtra("taskId",alreadyMatters.get(position).getRunId());
        }
        startNewActivityNoramlWithIntent(mIntent);
    }
}
