package com.gagakj.intel4android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseFragment;
import com.gagakj.intel4android.network.http.ResultSubscriber;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.OltInfoListResponse;

/**
 * 当前类注释:OLT详细信息 Fragmet 单个OLT详细信息
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.fragment
 * 作者：江清清 on 2017/6/8 20:58
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class OLTItemInfoFragment extends BaseFragment implements View.OnClickListener,ResultSubscriber.OnResultListener{
    private View mView;

    private TextView tv_oltCname,tv_address,tv_ip,tv_vlan,tv_pon,tv_obd;
    private TextView tv_report_submit; //提交挂测报告

    private static final String KEY = "OLTItemInfoFragment";
    private OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean;//具体OLT信息，其中包含基本信息，挂测列表信息
    public static OLTItemInfoFragment newInstance(OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,bizOLtInfoListBean);
        OLTItemInfoFragment fragment=new OLTItemInfoFragment();
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
            mView = inflater.inflate(R.layout.olt_item_info_fragment , container , false);
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
        tv_oltCname = $(R.id.tv_oltCname);
        tv_address = $(R.id.tv_address);
        tv_ip = $(R.id.tv_ip);
        tv_vlan = $(R.id.tv_vlan);
        tv_pon = $(R.id.tv_pon);
        tv_obd = $(R.id.tv_obd);

        tv_report_submit = $(R.id.tv_report_submit);
    }

    @Nullable
    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void initValidata() {
        super.initValidata();
        tv_oltCname.setText(bizOLtInfoListBean.getOltCname());
        tv_address.setText(bizOLtInfoListBean.getOltIp());
        tv_ip.setText(bizOLtInfoListBean.getOltIp());
        tv_vlan.setText(bizOLtInfoListBean.getWWlan());
        tv_pon.setText(bizOLtInfoListBean.getPonPort());
        tv_obd.setText(bizOLtInfoListBean.getObd());
    }

    @Override
    public void initListener() {
        super.initListener();

        tv_report_submit.setOnClickListener(this);
    }

    @Override
    public void bindData() {
        super.bindData();
    }

    @Override
    public void onClick(View v) {

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

    }
}
