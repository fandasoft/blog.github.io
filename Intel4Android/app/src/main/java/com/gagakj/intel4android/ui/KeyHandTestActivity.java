package com.gagakj.intel4android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseActivity;
import com.gagakj.intel4android.common.RequestAction;
import com.gagakj.intel4android.network.http.HTTPHelper;
import com.gagakj.intel4android.network.http.ResultSubscriber;
import com.gagakj.intel4android.network.model.IModel;
import com.gagakj.intel4android.network.model.OLTTestResponse;
import com.gagakj.intel4android.network.model.OltInfoListResponse;

import java.sql.Time;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

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

public class KeyHandTestActivity extends BaseActivity implements View.OnClickListener ,ResultSubscriber.OnResultListener{
    private LinearLayout linear_back;
    private OltInfoListResponse.ResultsBean.BizOltGcInfoListBean bizOLtInfoListBean;//具体OLT信息，其中包含基本信息，挂测列表信息
    private Intent mIntent;
    private TextView tv_oltCname,tv_address,tv_ip,tv_vlan,tv_pon,tv_obd;
    private ProgressBar pb_progressbar;
    private TextView tv_report_gc;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                showShortToast("挂测完成!");
                mIntent = new Intent(KeyHandTestActivity.this,ResultTestActivity.class);
                //TODO  mIntent.putExtra("gc_id",oltTestResponse.getBizOltGcInfo().getId()+"");
                mIntent.putExtra("gc_id",bizOLtInfoListBean.getId()+"");
                startNewActivityNoramlWithIntent(mIntent);
                timer.cancel();
            }
        }
    };
    private int progress = 0;
    private OLTTestResponse oltTestResponse;
    private TimerTask timerTask;
    private Timer timer;
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
        pb_progressbar = $(R.id.pb_progressbar);
        pb_progressbar.setProgress(progress);

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

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(progress >= 100){
                    progress = 0;
                    mHandler.sendEmptyMessage(1);
                }
                progress += 1;
                pb_progressbar.setProgress(progress);
            }
        };
        timerTask.run();
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
                HashMap<String,String> req_map = new HashMap<>();
                req_map.put("id",bizOLtInfoListBean.getId()+"");
                HTTPHelper.getInstance().oltTestReq(OLTTestResponse.class,req_map, RequestAction.ACTION_OLT_TEST,this);
                showProgressDialog("正在一键挂测中...");
                timer.schedule(timerTask,0,30);
                break;
            default:
                break;
        }
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
        if(requestType == RequestAction.ACTION_OLT_TEST){
            oltTestResponse = (OLTTestResponse)t;
            if(oltTestResponse.isSuccess()){

            }
        }
    }
}
