package com.gagakj.intel4android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.base.CommonAdapter;
import com.gagakj.intel4android.adapter.base.ViewHolder;
import com.gagakj.intel4android.base.BaseFragment;
import com.gagakj.intel4android.common.RequestAction;
import com.gagakj.intel4android.network.http.HTTPHelper;
import com.gagakj.intel4android.network.http.ResultSubscriber;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.PendingMattersGcResponse;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.network.model.TaskOpinionsResponse;

import java.util.HashMap;
import java.util.List;

/**
 * 当前类注释:审批历史
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/8 20:33
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class ApprovalHistoryGcFragment extends BaseFragment implements ResultSubscriber.OnResultListener{
    private View mView;
    private static final String KEY = "ApprovalHistoryGcFragment";
    private static final String KEY_RUNID = "key_runid";
    private static final String KEY_TYPE = "key_type";
    private CommonAdapter<TaskOpinionsResponse.ResultsBean>  commonAdapter;
    private ListView lv_list_task;

    private String taskOrId;
    private String runId;
    private int type;
    public static ApprovalHistoryGcFragment newInstance(String taskOrId,String runId,int type){
        Bundle bundle=new Bundle();
        bundle.putString(KEY,taskOrId);
        bundle.putString(KEY_RUNID,runId);
        bundle.putInt(KEY_TYPE,type);
        ApprovalHistoryGcFragment fragment=new ApprovalHistoryGcFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            taskOrId = bundle.getString(KEY);
            runId = bundle.getString(KEY_RUNID);
            type = bundle.getInt(KEY_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            mView = inflater.inflate(R.layout.approval_histroy_fragment , container , false);
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

    @Nullable
    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void initValidata() {
        super.initValidata();
        HashMap<String,String> req_map = new HashMap<>();
        if(type != 3)
        {
            req_map.put("taskId",taskOrId);
            Log.d("zttjiangqq","taskId:"+taskOrId);
        }else{
            req_map.put("runId",runId);
            Log.d("zttjiangqq","runId:"+runId);
        }
        HTTPHelper.getInstance().taskOpinionsReq(TaskOpinionsResponse.class,req_map, RequestAction.ACTION_TASK_OPINIONS,this);

    }

    @Override
    public void initListener() {
        super.initListener();
    }

    @Override
    public void bindData() {
        super.bindData();
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
        if(requestType == RequestAction.ACTION_TASK_OPINIONS){
            TaskOpinionsResponse taskOpinionsResponse = (TaskOpinionsResponse)t;
            List<TaskOpinionsResponse.ResultsBean> taskOpinions = taskOpinionsResponse.getResults();
            if(taskOpinions != null && taskOpinions.size() > 0){
                renderTaskOp(taskOpinions);
            }
        }
    }

    private void renderTaskOp(List<TaskOpinionsResponse.ResultsBean> taskOpinions){
        commonAdapter = new CommonAdapter<TaskOpinionsResponse.ResultsBean>(getActivity(),taskOpinions,R.layout.item_approval_list) {
            @Override
            public void convert(ViewHolder holder, TaskOpinionsResponse.ResultsBean item) {
                String status = item.getStatus();
                if(status.equals("正在审批")){
                    status = "正在处理";
                }
                holder.setText(R.id.tv_taskbox_name,item.getTaskName())
                        .setText(R.id.tv_worker_status,status)
                        .setText(R.id.tv_worker_time, "耗时:"+item.getDurTimeStr()+"   处理时间:"+item.getEndTimeStr())
                        .setText(R.id.tv_pub,item.getExeFullname());
            }
        };
        lv_list_task.setAdapter(commonAdapter);

    }

}
