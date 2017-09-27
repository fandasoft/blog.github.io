package com.gagakj.intel4android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseActivity;
import com.gagakj.intel4android.network.model.OltInfoListResponse;

/**
 * 当前类注释:一键挂测界面
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.ui
 * 作者：江清清 on 2017/6/8 15:05
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class KeyHandTestActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout linear_back;
    private OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean;//具体OLT信息，其中包含基本信息，挂测列表信息
    private Intent mIntent;
    private TextView tv_oltCname,tv_address,tv_ip,tv_vlan,tv_pon,tv_obd;
    private ProgressBar pb_progressbar;
    private TextView tv_report_gc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.key_hand_test_layout);
        mIntent = getIntent();
        initView();
        initValidata();
        initListener();
        bindData();
    }

    @Override
    public void initView() {
        super.initView();
        linear_back = $(R.id.linear_back);
        tv_oltCname = $(R.id.tv_oltCname);
        tv_address = $(R.id.tv_address);
        tv_ip = $(R.id.tv_ip);
        tv_vlan = $(R.id.tv_vlan);
        tv_pon = $(R.id.tv_pon);
        tv_obd = $(R.id.tv_obd);
        tv_report_gc = $(R.id.tv_report_gc);
    }

    @Override
    public void initValidata() {
        super.initValidata();
        if(mIntent != null){
            bizOLtInfoListBean = (OltInfoListResponse.ResultsBean.BizOltGcInfoListBean)mIntent.getSerializableExtra("gc_info");
            tv_oltCname.setText(bizOLtInfoListBean.getOltCname());
            tv_address.setText(bizOLtInfoListBean.getOltIp());
            tv_ip.setText(bizOLtInfoListBean.getOltIp());
            tv_vlan.setText(bizOLtInfoListBean.getWWlan());
            tv_pon.setText(bizOLtInfoListBean.getPonPort());
            tv_obd.setText(bizOLtInfoListBean.getObd());
        }
    }

    @Override
    public void initListener() {
        super.initListener();
        linear_back.setOnClickListener(this);
        tv_report_gc.setOnClickListener(this);
    }

    @Override
    public void bindData() {
        super.bindData();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_back :
                finish(this);
                break;
            case R.id.tv_report_gc:
                startNewActivityNoraml(this,ResultTestActivity.class);
                break;
            default:
                break;
        }
    }
}
