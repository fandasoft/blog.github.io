package com.gagakj.intel4android;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 进行管理所有的Activity
 * 
 * @author jiangqq
 * @time 2013/12/04 15:50
 * 
 */
public class ManagerActivity {
	public static ManagerActivity instance = new ManagerActivity();
	private List<Activity> mLists = new ArrayList<Activity>();

	private ManagerActivity() {
	}

	public synchronized static ManagerActivity getInstance() {
		return instance;
	}

	public void addActivity(Activity pActivity) {
		if (pActivity != null) {
			mLists.add(pActivity);
		}
	}

	public void removeActivity(Activity pActivity) {
		if (pActivity != null) {
			if (mLists.contains(pActivity)) {
				mLists.remove(pActivity);
				pActivity.finish();
				pActivity = null;
			}
		}
	}

	public void removeActivity() {
		Activity activity = mLists.get(mLists.size() - 1);
		removeActivity(activity);
	}

	public int getNum() {
		return mLists.size();
	}

	public void finishActivity() {
		if (mLists != null && mLists.size() >= 0) {
			for (Activity pActivity : mLists) {
				pActivity.finish();
				pActivity = null;
			}
		}
	}
}
