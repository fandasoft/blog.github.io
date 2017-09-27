package com.gagakj.intel4android.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseActivity;

/**
 * 当前类注释:挂测结果页面
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.ui
 * 作者：江清清 on 2017/6/8 15:05
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class ResultTestActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout linear_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_test_layout);
        initView();
        initValidata();
        initListener();
        bindData();
    }
    @Override
    public void initView() {
        super.initView();
        linear_back = $(R.id.linear_back);
    }

    @Override
    public void initValidata() {
        super.initValidata();
    }

    @Override
    public void initListener() {
        super.initListener();
        linear_back.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
