package com.gagakj.intel4android.network.http;


import android.content.Context;

import com.gagakj.intel4android.network.interfaces.INetInterface;
import com.gagakj.intel4android.network.model.IModel;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @Author: lizhipeng
 * @Data: 16/4/12 下午3:27
 * @Description: 网络请求数据类（单例）
 */
public class OtherHTTPHelper {

    /**
     * 这一部分配置常量，可以抽取出常量类
     */
    private static final String BASE_PATH = "http://v.juhe.cn/usedcar/";//访问的地址
    private static final long DEFAULT_TIMEOUT = 10000;//默认超时时间(毫秒)

    private Context mContext;
    private Retrofit mRetrofit;
    private INetInterface mNetService;

    private OtherHTTPHelper() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//        okHttpClient.addNetworkInterceptor(new HTTPInterceptor());
        okHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);//等待服务器响应的时间
        okHttpClient.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_PATH)
                .build();
        mNetService = mRetrofit.create(INetInterface.class);
    }

    /**
     * 单例控制器
     */
    private static class SingletonHolder {
        private static final OtherHTTPHelper INSTANCE = new OtherHTTPHelper();
    }

    /**
     * 获取单例对象
     *
     * @return
     */
    public static OtherHTTPHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }
    /**
     * 类型转换，用来统一处理返回值，通常为公共message返回字段等。具体业务这里要具体操作
     *
     * @param <T> Subscriber真正需要的数据类型，也就是返回值针对的model
     */
    private class HttpResultFunc<T> implements Func1<IModel, T> {
        @Override
        public T call(IModel iModel) {
            if (iModel == null) {
                try {
                    throw new Exception("result model is null");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            T t = (T) iModel;
            if (t == null) {
                try {
                    throw new Exception("cast to the model is null");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return t;
        }
    }

    /**
     * 初始化观察者
     * @param observable
     * @param resultType
     * @param listener
     */
    private Subscriber initObservable(Observable observable, int resultType, ResultSubscriber.OnResultListener listener) {
        ResultSubscriber subscriber = new ResultSubscriber(mContext);
        subscriber.setOnResultListener(listener);
        subscriber.setRequestType(resultType);
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        return subscriber;
    }
    //********************************对应 INetService接口中定义的请求方法*************************************************//


}
