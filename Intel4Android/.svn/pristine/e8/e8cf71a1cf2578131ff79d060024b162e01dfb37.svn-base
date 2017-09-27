package com.gagakj.intel4android.application;

import android.app.Application;
import android.view.WindowManager;


import com.gagakj.intel4android.common.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;


/**
 * 当前类注释: 自定义全局Application类 做一下全局配置项等
 * 项目名：Ssds4Android
 * 包名：com.gagakj.ssds4android.application
 * 作者：江清清 on 2017/4/27 14:44
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */


public class IntelApplication extends Application {

    private HashMap<String, Object> tempMap = new HashMap<String, Object>();

    private static IntelApplication instance = null;

    // 使用单例返回唯一的Application的实例
    public static IntelApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        cacheDirCreate();
    }

    public HashMap<String,Object> getTempMap(){
        return tempMap;
    }
    /**
     * 缓存文件夹创建
     */
    private void cacheDirCreate(){
        File file_base = new File(Constants.FILE_BASE_PATH);
        if(file_base == null || !file_base.exists()){
            file_base.mkdir();
        }
    }
}
