package com.gagakj.intel4android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseFragment;
import com.gagakj.intel4android.common.RequestAction;
import com.gagakj.intel4android.network.http.HTTPHelper;
import com.gagakj.intel4android.network.http.ResultSubscriber;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.PendingMattersGcResponse;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.network.model.TaskFormResponse;
import com.gagakj.intel4android.utils.DateUtil;

import java.util.HashMap;

/**
 * 当前类注释:工程信息Fragment
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/8 20:16
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class EngineerInfoGcFragment extends BaseFragment implements ResultSubscriber.OnResultListener{
    private View mView;
    //控件定义
    private TextView tv_gongchengbianhao,tv_gongchengmingchen,tv_xiangmujibie;
    private TextView tv_guanliguanxi,tv_lixiangbumen,tv_shejidanwei,tv_jianshedanwei;
    private TextView tv_xiangmujingli,tv_begin_time,tv_end_time;
    private TextView tv_jianlidanwei,tv_shigongdanwei,tv_shiyongdanwei;
    private TextView tv_zhuyaoneirong;


    private static final String KEY = "EngineerInfoFragment";

    private PendingMattersGcResponse.ResultsBean pendingMattersModel;  //外部传过来的在办任务信息
    public static EngineerInfoGcFragment newInstance(PendingMattersGcResponse.ResultsBean pendingMattersModel){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,pendingMattersModel);
        EngineerInfoGcFragment fragment=new EngineerInfoGcFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            pendingMattersModel=(PendingMattersGcResponse.ResultsBean)bundle.getSerializable(KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            mView = inflater.inflate(R.layout.engineer_info_fragment , container , false);
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

        tv_gongchengbianhao = $(R.id.tv_gongchengbianhao);
        tv_gongchengmingchen = $(R.id.tv_gongchengmingchen);
        tv_xiangmujibie = $(R.id.tv_xiangmujibie);

        tv_guanliguanxi = $(R.id.tv_guanliguanxi);
        tv_lixiangbumen = $(R.id.tv_lixiangbumen);
        tv_shejidanwei = $(R.id.tv_shejidanwei);
        tv_jianshedanwei = $(R.id.tv_jianshedanwei);
        tv_xiangmujingli = $(R.id.tv_xiangmujingli);
        tv_begin_time = $(R.id.tv_begin_time);
        tv_end_time = $(R.id.tv_end_time);
        tv_jianlidanwei = $(R.id.tv_jianlidanwei);
        tv_shigongdanwei = $(R.id.tv_shigongdanwei);
        tv_shiyongdanwei = $(R.id.tv_shiyongdanwei);
        tv_zhuyaoneirong = $(R.id.tv_zhuyaoneirong);
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
        req_map.put("taskId",pendingMattersModel.getId());
        HTTPHelper.getInstance().taskFormReq(TaskFormResponse.class,req_map, RequestAction.ACTION_TASK_FORM,this);
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
        if(requestType == RequestAction.ACTION_TASK_FORM){
            TaskFormResponse taskFormResponse = (TaskFormResponse)t;
            if(taskFormResponse.isSuccess()){
                renderTaskForm(taskFormResponse.getBizProjectInfo());
            }
        }
    }

    /**
     * 进行刷新工程信息
     * @param bizProjectInfoBean
     */
    private void renderTaskForm(TaskFormResponse.BizProjectInfoBean bizProjectInfoBean){
        tv_gongchengbianhao.setText(bizProjectInfoBean.getProsn());
        tv_gongchengmingchen.setText(bizProjectInfoBean.getProname());
        tv_xiangmujibie.setText(bizProjectInfoBean.getProlevelid());

        tv_guanliguanxi.setText(bizProjectInfoBean.getManagingrelationid());
        tv_lixiangbumen.setText(bizProjectInfoBean.getSetdeptname());
        tv_shejidanwei.setText(bizProjectInfoBean.getDesigndeptname());
        tv_jianshedanwei.setText(bizProjectInfoBean.getBuilddeptname());
        tv_xiangmujingli.setText(bizProjectInfoBean.getProjectmanager());

        tv_begin_time.setText(DateUtil.getDateTime(bizProjectInfoBean.getPlanbegindate().getTime(),"yyyy-MM-dd"));
        tv_end_time.setText(DateUtil.getDateTime(bizProjectInfoBean.getPlanenddate().getTime(),"yyyy-MM-dd"));

        tv_jianlidanwei.setText(bizProjectInfoBean.getSupervisordeptname());
        tv_shigongdanwei.setText(bizProjectInfoBean.getConstructdeptname());
        tv_shiyongdanwei.setText(bizProjectInfoBean.getUsedeptname());

        tv_zhuyaoneirong.setText(bizProjectInfoBean.getContent());
    }
}
