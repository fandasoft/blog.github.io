package com.gagakj.intel4android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.adapter.base.CommonAdapter;
import com.gagakj.intel4android.adapter.base.ViewHolder;
import com.gagakj.intel4android.base.BaseFragment;
import com.gagakj.intel4android.common.RequestAction;
import com.gagakj.intel4android.network.http.HTTPHelper;
import com.gagakj.intel4android.network.http.ResultSubscriber;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.OLTGcInfoListResponse;
import com.gagakj.intel4android.network.model.OltInfoListResponse;
import com.gagakj.intel4android.ui.KeyHandTestActivity;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.HTTP;

/**
 * 当前类注释:挂测列表
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/8 21:00
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class OLTTestFragment extends BaseFragment implements AdapterView.OnItemClickListener,ResultSubscriber.OnResultListener{
    private View mView;
    private static final String KEY = "OLTTestFragment";
    private ListView lv_list_task;
    private Intent mIntent ;
    private OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean;//具体OLT信息，其中包含基本信息
    private List<OLTGcInfoListResponse.ResultsBean> bizOltGcInfoListBeans;  //具体挂测列表
    private CommonAdapter<OLTGcInfoListResponse.ResultsBean> commonAdapter;
    public static OLTTestFragment newInstance(OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,bizOLtInfoListBean);
        OLTTestFragment fragment=new OLTTestFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            bizOLtInfoListBean=(OltInfoListResponse.ResultsBean.BizOltGcInfoListBean)bundle.getSerializable(KEY);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            mView = inflater.inflate(R.layout.olt_test_fragment , container , false);
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
        reqData();
    }
    /**
     * 进行获取数据
     */
    private void reqData(){
        HashMap<String,String> req_map = new HashMap<>();
        req_map.put("id",bizOLtInfoListBean.getId()+"");
        HTTPHelper.getInstance().getOltGcInfoListReq(OLTGcInfoListResponse.class,req_map, RequestAction.ACTION_GET_OLTGCLIST,OLTTestFragment.this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        OLTGcInfoListResponse.ResultsBean gcInfoModel = bizOltGcInfoListBeans.get(position);
        mIntent = new Intent(getActivity(), KeyHandTestActivity.class);
        if(gcInfoModel.getResult().equals("未挂测")){
            mIntent.putExtra("gc_info",bizOLtInfoListBean);
            startNewActivityNoramlWithIntent(mIntent);
        }
    }

    /**
     * 刷新
     */
    private void renderOLTTest(List<OLTGcInfoListResponse.ResultsBean> bizOltGcInfoListBeans){
        commonAdapter = new CommonAdapter<OLTGcInfoListResponse.ResultsBean>(getActivity(),bizOltGcInfoListBeans,R.layout.olt_list_item_layout) {
            @Override
            public void convert(ViewHolder holder, OLTGcInfoListResponse.ResultsBean item) {
                holder.setText(R.id.tv_oltcname,item.getOltCname())
                        .setText(R.id.tv_desc,item.getOltIp()+","+item.getPonPort()+","+item.getWWlan()+","+item.getResult());
            }
        };
        lv_list_task.setAdapter(commonAdapter);
    }

    @Override
    public void onStart(int requestType) {

    }

    @Override
    public void onCompleted(int requestType) {

    }

    @Override
    public void onError(int requestType) {
        showShortToast("数据加载失败!");
    }

    @Override
    public void onNext(IModel t, int requestType) {
        if(requestType == RequestAction.ACTION_GET_OLTGCLIST){
            OLTGcInfoListResponse oltGcInfoListResponse = (OLTGcInfoListResponse)t;
            if(oltGcInfoListResponse.getTotalCounts() > 0  && (bizOltGcInfoListBeans = oltGcInfoListResponse.getResults())!=null){
                renderOLTTest(bizOltGcInfoListBeans);
            }
        }
    }
}
