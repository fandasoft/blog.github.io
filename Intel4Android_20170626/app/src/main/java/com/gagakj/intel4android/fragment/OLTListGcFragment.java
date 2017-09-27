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
import com.gagakj.intel4android.network.model.OltInfoListResponse;
import com.gagakj.intel4android.network.model.PendingMattersGcResponse;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.ui.OLTInfoFrameActivity;

import java.util.HashMap;
import java.util.List;

/**
 * 当前类注释:OLT列表界面
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/8 20:29
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class OLTListGcFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener,ResultSubscriber.OnResultListener{
    private View mView;
    private ListView lv_list_task;
    private static final String KEY = "OLTListFragment";

    private String taskOrId;
    private CommonAdapter<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean> oLtInfoListBeensAdapter;
    private List<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean> bizOLtInfoListBeans;


    public static OLTListGcFragment newInstance(String taskOrId){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,taskOrId);
        OLTListGcFragment fragment=new OLTListGcFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            taskOrId = bundle.getString(KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            mView = inflater.inflate(R.layout.olt_list_fragment , container , false);
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
        HashMap<String,String> req_map = new HashMap<>();
        //TODO 这边正式接口需要做调整
        req_map.put("id","10000009860329");
        HTTPHelper.getInstance().getOltInfoListReq(OltInfoListResponse.class,req_map, RequestAction.ACTION_OLEINFOLIST,this);

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
    public void onClick(View v) {

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent mIntent = new Intent(getActivity(), OLTInfoFrameActivity.class);
        mIntent.putExtra("olt_info",bizOLtInfoListBeans.get(position));
        startNewActivityNoramlWithIntent(mIntent);
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
        if(requestType == RequestAction.ACTION_OLEINFOLIST){
            OltInfoListResponse oltInfoListResponse = (OltInfoListResponse)t;
            bizOLtInfoListBeans = oltInfoListResponse.getResults().get(0).getBizOltGcInfoList();
            if(bizOLtInfoListBeans != null && bizOLtInfoListBeans.size()>0){
                renderOltInfoList(bizOLtInfoListBeans);
            }
        }
    }

    /**
     * 进行刷新OLT列表
     * @param pBizOLtInfoListBeans
     */
    private void renderOltInfoList(List<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean> pBizOLtInfoListBeans){
        oLtInfoListBeensAdapter = new CommonAdapter<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean>(getActivity(),pBizOLtInfoListBeans,R.layout.olt_list_item_layout) {
            @Override
            public void convert(ViewHolder holder, OltInfoListResponse.ResultsBean.BizOltGcInfoListBean item) {
                //TODO 数据显示后期会进行重构
                holder.setText(R.id.tv_oltcname,item.getOltCname())
                        .setText(R.id.tv_desc,item.getOltIp()+","+item.getPonPort()+","+item.getWWlan());
            }
        };
        lv_list_task.setAdapter(oLtInfoListBeensAdapter);
    }
}
