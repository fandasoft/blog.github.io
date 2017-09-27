package com.gagakj.intel4android.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.application.IntelApplication;
import com.gagakj.intel4android.base.BaseActivity;
import com.gagakj.intel4android.common.RequestURL;
import com.gagakj.intel4android.network.model.LoginRespose;
import com.gagakj.intel4android.utils.Log;
import com.gagakj.intel4android.utils.OkhttpManager;
import com.gagakj.intel4android.utils.SharedPreferencesHelper;
import com.gagakj.intel4android.utils.SharedPreferencesTag;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_login ;
    private EditText ed_username;
    private EditText ed_password;

    private String user_name;
    private String pass_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }

    @Override
    public void initView() {
        super.initView();
        tv_login = $(R.id.tv_login);

        ed_username = $(R.id.ed_username);
        ed_password = $(R.id.ed_password);
    }

    @Override
    public void initValidata() {
        super.initValidata();
    }

    @Override
    public void initListener() {
        super.initListener();
        tv_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login :
                user_name = ed_username.getText().toString().trim();
                pass_word = ed_password.getText().toString().trim();
                if(user_name == null || pass_word.equals("")){
                    showShortToast("请输入账号!");
                    return;
                }
                if(pass_word == null || pass_word.equals("")){
                    showShortToast("请输入密码!");
                    return;
                }
                showProgressDialog("正在登录中!");
                HashMap<String,String> map = new HashMap<>();
                map.put("username",user_name);
                map.put("password",pass_word);
                map.put("lang","1");
                map.put("validateType","");
                OkhttpManager.getAsyncParams(RequestURL.LOGIN_URL, map, new OkhttpManager.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, Exception e) {
                        hideProgressDialog();
                        showShortToast("登录失败!");
                    }
                    @Override
                    public void requestSuccess(String result) {
                        hideProgressDialog();

                        int begin = result.indexOf("(");
                        int end = result.indexOf(")");
                        Gson gson = new Gson();
                        LoginRespose loginRespose = gson.fromJson(result.substring(begin+1,end), LoginRespose.class);

                        LoginRespose.UserBean userBean = loginRespose.getUser();
                        String user_id = "";
                        if(userBean != null){
                            user_id = userBean.getUserId()+"";
                        }
                        Log.d("zttjiangqq","user_id:"+user_id);
                        //保存userid
                        SharedPreferencesHelper.getInstance(IntelApplication.getInstance()).putStringValue(SharedPreferencesTag.KEY_USERID,user_id);
                        startNewActivityNoraml(LoginActivity.this , MainActivity.class);
                        finish(LoginActivity.this);
                    }
                });
                break;
            default:
                break;
        }
    }
}
