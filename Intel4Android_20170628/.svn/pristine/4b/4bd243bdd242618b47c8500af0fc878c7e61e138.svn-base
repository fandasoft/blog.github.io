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
import com.gagakj.intel4android.network.model.OltInfoListResponse;

import java.util.List;

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

public class OLTTestFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    private View mView;
    private static final String KEY = "OLTTestFragment";
    private ListView lv_list_task;
    private Intent mIntent ;
    private OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean;//具体OLT信息，其中包含基本信息，挂测列表信息
    private List<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean> bizOltGcInfoListBeans; //挂测列表信息集合
    private CommonAdapter<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean> commonAdapter;
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
            //获取挂测列表
            //

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
        OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOltGcInfoListBean = bizOltGcInfoListBeans.get(position);
        String result = bizOltGcInfoListBean.getResult();
        if(result.equals("未测试")){

        }else {
            //通过、未通过
        }
    }

    /**
     * 刷新
     */
    private void renderOLTTest(){
        commonAdapter = new CommonAdapter<OltInfoListResponse.ResultsBean.BizOltGcInfoListBean>(getActivity(),bizOltGcInfoListBeans,R.layout.olt_list_item_layout) {
            @Override
            public void convert(ViewHolder holder, OltInfoListResponse.ResultsBean.BizOltGcInfoListBean item) {
                holder.setText(R.id.tv_oltcname,item.getOltCname())
                        .setText(R.id.tv_desc,item.getOltIp()+","+item.getPonPort()+","+item.getWWlan()+","+item.getResult());
            }
        };
        lv_list_task.setAdapter(commonAdapter);
    }
}
