package com.gagakj.intel4android.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private LinearLayout linear_waiting_task ;
    private LinearLayout linear_underway_task ;
    private LinearLayout linear_finished_task ;

    private LinearLayout test_waiting_task ;
    private LinearLayout test_underway_task ;
    private LinearLayout test_finished_task ;
    private LinearLayout linear_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    @Override
    public void initView() {
        super.initView();
        //移动审批
        linear_waiting_task = $(R.id.linear_waiting_task);
        linear_underway_task = $(R.id.linear_underway_task);
        linear_finished_task = $(R.id.linear_finished_task);

        //智能挂载
        test_waiting_task = $(R.id.test_waiting_task);
        test_underway_task = $(R.id.test_underway_task);
        test_finished_task = $(R.id.test_finished_task);

        linear_logout = $(R.id.linear_logout);
    }

    @Override
    public void initListener() {
        super.initListener();
        linear_waiting_task.setOnClickListener(this);
        linear_underway_task.setOnClickListener(this);
        linear_finished_task.setOnClickListener(this);

        test_waiting_task.setOnClickListener(this);
        test_underway_task.setOnClickListener(this);
        test_finished_task.setOnClickListener(this);

        linear_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_waiting_task:
                //点击等待任务
                Intent intent_waiting = new Intent(MainActivity.this , TaskStatusActivity.class);
                intent_waiting.putExtra("viewpager" , 0);
                startActivity(intent_waiting);
                break;
            case R.id.linear_underway_task:
                //点击在办任务
                Intent intent_underway = new Intent(MainActivity.this , TaskStatusActivity.class);
                intent_underway.putExtra("viewpager" , 1);
                startActivity(intent_underway);
                break;
            case R.id.linear_finished_task:
                //点击完成任务
                Intent intent_finished = new Intent(MainActivity.this , TaskStatusActivity.class);
                intent_finished.putExtra("viewpager" , 2);
                startActivity(intent_finished);
                break;

            case R.id.test_waiting_task:
                //挂测 待办
                Intent test_waiting = new Intent(MainActivity.this , TaskStatusGcActivity.class);
                test_waiting.putExtra("viewpager" , 0);
                startActivity(test_waiting);
                break;
            case R.id.test_underway_task:
                //挂测 在办
                Intent test_underway = new Intent(MainActivity.this , TaskStatusGcActivity.class);
                test_underway.putExtra("viewpager" , 1);
                startActivity(test_underway);
                break;
            case R.id.test_finished_task:
                //挂测 已办
                Intent test_finished = new Intent(MainActivity.this , TaskStatusGcActivity.class);
                test_finished.putExtra("viewpager" , 2);
                startActivity(test_finished);
                break;
            case R.id.linear_logout:
                new AlertDialog.Builder(MainActivity.this).setTitle("温馨提示").setMessage("确定退出?").setNegativeButton("取消",null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(MainActivity.this);
                    }
                }).create().show();
                break;
        }
    }
}
