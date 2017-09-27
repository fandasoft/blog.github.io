package com.gagakj.intel4android.utils;

import android.content.Context;

import com.gagakj.intel4android.application.IntelApplication;;


/**
 * 查询与设置引导界面标志值工具类
 * @author Jiangqq
 * @time 2014/03/27 10:28
 */
public class GuideUtils {
	/**
	 * 根据版本code值 判断是否已经引导过了
	 * @param context  上下文
	 * @param versionCode  版本值
	 * @return  引导过返回true,否则返回false
	 */
	 public static boolean activityIsGuided(Context context, int versionCode){
		 SharedPreferencesHelper mSharedPreferencesHelper=SharedPreferencesHelper.getInstance(IntelApplication.getInstance());
		 if(mSharedPreferencesHelper.getIntValue(SharedPreferencesTag.KEY_GUIDE_ACTIVITY)==versionCode){
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	  * 设置code值，表明已经引导过
	  * @param context
	  * @param versionCode
	  */
	 public static void setIsGuided(Context context, int versionCode){
		 SharedPreferencesHelper mSharedPreferencesHelper=SharedPreferencesHelper.getInstance(IntelApplication.getInstance());
		 mSharedPreferencesHelper.putIntValue(SharedPreferencesTag.KEY_GUIDE_ACTIVITY, versionCode);
	 }
}
