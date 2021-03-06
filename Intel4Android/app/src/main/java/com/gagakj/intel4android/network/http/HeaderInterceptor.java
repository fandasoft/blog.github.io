package com.gagakj.intel4android.network.http;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.gagakj.intel4android.application.IntelApplication;
import com.gagakj.intel4android.utils.SharedPreferencesHelper;
import com.gagakj.intel4android.utils.SharedPreferencesTag;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 当前类注释:
 * 项目名：NightLive4Android
 * 包名：com.gagakj.intel4android.network.http
 * 作者：江清清 on 2016/12/21 15:31
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class HeaderInterceptor implements Interceptor {
    private Context context;
    public HeaderInterceptor(Context context){
        this.context = context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        String sessionId = SharedPreferencesHelper.getInstance(IntelApplication.getInstance())
                .getStringValue(SharedPreferencesTag.KEY_SESSIONGID);
        Log.d("zttjiangqq","sessionId:"+sessionId);
        Request.Builder requestBuilder = original.newBuilder()
                .header("Cookie",sessionId); //添加sessionId
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
