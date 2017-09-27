package com.gagakj.intel4android.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.common.DefineView;
import com.gagakj.intel4android.eventbus.EventMessage;
import com.gagakj.intel4android.utils.DialogUtils;
import com.gagakj.intel4android.utils.Log;
import com.gagakj.intel4android.view.IBaseView;
import com.gagakj.intel4android.view.IDialogView;

import java.util.List;

import de.greenrobot.event.EventBus;


/**
 * 该为所有Fragment的基类Fragment
 * @author hmjiangqq
 * @time 2014/03/05  14:50
 *
 */
public class BaseFragment extends Fragment implements IBaseView, IDialogView, DefineView {
	private static final String TAG="lifecycle";
	private AlertDialog progressDialog;
	private AlertDialog infoDialog;
	private AlertDialog alertDialog;
	private AlertDialog listDialog;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.i(TAG, "------->>onAttach");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i(TAG, "------->>onConfigurationChanged");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "------->>onCreate");
		EventBus.getDefault().register(this);

	}

	public void setStatus(){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(true);
		}

	}
	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getActivity().getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		Log.i(TAG, "------->>onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "------->>onDestroy");
		EventBus.getDefault().unregister(this);

	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.i(TAG, "------->>onDestroyView");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.i(TAG, "------->>onDetach");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG, "------->>onPause");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(TAG, "------->>onResume");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i(TAG, "------->>onStart");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG, "------->>onStop");
	}
	public <T> T $(int viewID) {
		return (T) getView().findViewById(viewID);
	}

	public void makeTextShort(String text) {
		Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
	}

	public void makeTextLong(String text) {
		Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
	}
	/**
	 * 正常打开新的Activity 动画效果右向左推
	 * 
	 * @param pContext
	 * @param pClass
	 */
	public void startNewActivityNoraml(Context pContext, Class<?> pClass) {
		startNewActivity(pContext, pClass);
		getActivity().overridePendingTransition(R.anim.move_push_in, R.anim.move_push_out);
	}

	/**
	 * 打开新的Activity 动画效果下向上推
	 * 
	 * @param pContext
	 * @param pClass
	 */
	public void startNewActivityUp(Context pContext, Class<?> pClass) {
		startNewActivity(pContext, pClass);
		getActivity().overridePendingTransition(R.anim.move_push_up_in,
				R.anim.move_push_up_out);
	}

	/**
	 * 打开新的Activity 默认效果
	 * 
	 * @param pContext
	 * @param pClass
	 */
	private void startNewActivity(Context pContext, Class<?> pClass) {
		Intent mIntent = new Intent(pContext, pClass);
		getActivity().startActivity(mIntent);
	}

	/**
	 * 正常打开新的Activity 动画效果右向左推 带上Intent
	 * @param intent
	 *
	 */
	public void startNewActivityNoramlWithIntent(Intent intent) {
		startActivity(intent);
		getActivity().overridePendingTransition(R.anim.move_push_in, R.anim.move_push_out);
	}

	@Override
	public void initView() {

	}

	@Override
	public void initValidata() {

	}

	@Override
	public void initListener() {

	}

	@Override
	public void bindData() {

	}

	@Override
	public void initAdapter() {

	}

	@Override
	public String getTextStr(int viewId) {
		return ((TextView)getView().findViewById(viewId)).getText().toString();
	}

	@Override
	public void setTextStr(int viewId, String str) {
		((TextView)getView().findViewById(viewId)).setText(str);
	}

	@Override
	public void setBtnClickable(int viewId, boolean isClickable) {
		getView().findViewById(viewId).setClickable(isClickable);
	}

	@Override
	public void setViewVisible(int viewId, int visible) {
		getView().findViewById(viewId).setVisibility(visible);
	}

	@Override
	public void setTextColor(int viewId, int color) {
		((TextView)getView().findViewById(viewId)).setTextColor(color);
	}

	@Override
	public void showShortToast(String info) {
		Toast.makeText(getActivity(),info, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showLongToast(String info) {
		Toast.makeText(getActivity(),info, Toast.LENGTH_LONG).show();
	}

	@Override
	public void showProgressDialog(String info) {
		progressDialog = DialogUtils.createProgressDialog(getActivity(), info);
	}
	public void showProgressDialog(int info) {
		progressDialog = DialogUtils.createProgressDialog(getActivity(), info);
	}
	@Override
	public void hideProgressDialog() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}

	@Override
	public void showInfoDialog(String btnStr, String info, View.OnClickListener onClickListener) {
		infoDialog = DialogUtils.createInfoDialog(getActivity(), btnStr, info, onClickListener);
	}

	@Override
	public void hideInfoDialog() {
		if (infoDialog != null && infoDialog.isShowing()) {
			infoDialog.dismiss();
			infoDialog = null;
		}
	}

	@Override
	public void showAlertDialog(String leftBtnStr, String rightBtnStr, String message, View.OnClickListener leftOnClickListener, View.OnClickListener rightOnClickListener) {
		alertDialog = DialogUtils.createAlertDialog(getActivity(), leftBtnStr, rightBtnStr, message, leftOnClickListener, rightOnClickListener);
	}

	@Override
	public void hideAlertDialog() {
		if (alertDialog != null && alertDialog.isShowing()) {
			alertDialog.dismiss();
			alertDialog = null;
		}
	}

	@Override
	public void showListDialog(List<String> list, String title, AdapterView.OnItemClickListener onItemClickListener) {
		listDialog = DialogUtils.createListDialog(getActivity(), title,list, onItemClickListener);
	}

	@Override
	public void hideListDialog() {
		if (listDialog != null && listDialog.isShowing()) {
			listDialog.dismiss();
			listDialog = null;
		}
	}

	public void onEventMainThread(EventMessage eventModel) {

	}

//	//加载中,加载空,加载失败等Tip页面的控件
//	private FrameLayout prompt_framelayout;
//	private LinearLayout loading,empty,error;
//	private TextView tv_loading,empty_text,error_text;
//
//	public void initTipView(View view){
//		prompt_framelayout = (FrameLayout)view.findViewById(R.id.prompt_framelayout);
//		loading = (LinearLayout) view.findViewById(R.id.loading);
//		empty = (LinearLayout)view.findViewById(R.id.empty);
//		error = (LinearLayout)view.findViewById(R.id.error);
//
//		tv_loading = (TextView) view.findViewById(R.id.tv_loading);
//		empty_text = (TextView)view.findViewById(R.id.empty_text);
//		error_text = (TextView) view.findViewById(R.id.error_text);
//	}
//
//	public void showLoading(){
//		prompt_framelayout.setVisibility(View.VISIBLE);
//		loading.setVisibility(View.VISIBLE);
//		empty.setVisibility(View.GONE);
//		error.setVisibility(View.GONE);
//	}
//	public void showEmpty(){
//		prompt_framelayout.setVisibility(View.VISIBLE);
//		loading.setVisibility(View.GONE);
//		empty.setVisibility(View.VISIBLE);
//		error.setVisibility(View.GONE);
//	}
//
//	public void showError(){
//		prompt_framelayout.setVisibility(View.VISIBLE);
//		loading.setVisibility(View.GONE);
//		empty.setVisibility(View.GONE);
//		error.setVisibility(View.VISIBLE);
//	}
//	public void showSuccess(){
//		prompt_framelayout.setVisibility(View.GONE);
//		loading.setVisibility(View.GONE);
//		empty.setVisibility(View.GONE);
//		error.setVisibility(View.GONE);
//	}
}
