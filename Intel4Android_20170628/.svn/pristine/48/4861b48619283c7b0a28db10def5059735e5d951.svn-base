package com.gagakj.intel4android.base;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


import com.gagakj.intel4android.ManagerActivity;
import com.gagakj.intel4android.R;
import com.gagakj.intel4android.common.DefineView;
import com.gagakj.intel4android.eventbus.EventMessage;
import com.gagakj.intel4android.utils.ActivityUtils;
import com.gagakj.intel4android.utils.DialogUtils;
import com.gagakj.intel4android.utils.Log;
import com.gagakj.intel4android.utils.SharedPreferencesHelper;
import com.gagakj.intel4android.utils.SharedPreferencesTag;
import com.gagakj.intel4android.view.IBaseView;
import com.gagakj.intel4android.view.IDialogView;

import java.util.List;

import de.greenrobot.event.EventBus;


/**
 * Created by admin on 2015/10/21.
 */
public class BaseActivity extends FragmentActivity implements IBaseView, IDialogView, DefineView {
    private static final String TAG = "lifecycle";
    private AlertDialog progressDialog;
    private AlertDialog infoDialog;
    private AlertDialog alertDialog;
    private AlertDialog listDialog;
    public AlertDialog anotherPlaceDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //去除标题栏
        super.onCreate(savedInstanceState);
//        ManagerActivity.getInstance().addActivity(this);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
        ActivityUtils.getInstance().pushActivity(this);
        EventBus.getDefault().register(this);

    }
    public void setStatus(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }else{
            setTranslucentStatus(false);
        }

    }
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    /**
     * 封装进行获取控制对象
     * @param viewID
     * @param <T>
     * @return
     */
    public <T> T $(int viewID) {
        return (T) findViewById(viewID);
    }

    @Override
    public void onStart() {
        Log.i(TAG, "------->>onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "------->>onResume");
        super.onResume();


    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "------->>onStop");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("jinxb", "onKeyDown");
        if (anotherPlaceDialog != null && anotherPlaceDialog.isShowing()) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("jinxb", "EventBus---------------unregister");
        Log.i(TAG, "------->>onDestroy");
        hideInfoDialog();
        hideProgressDialog();
        hideListDialog();
        hideAlertDialog();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        ManagerActivity.getInstance().removeActivity(this);  //���ؼ��Ƴ�ǰ��Activity
        super.onBackPressed();
        Log.i(TAG, "------->>onBackPressed");
        overridePendingTransition(R.anim.move_pop_out, R.anim.move_pop_out);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "------->>onPause");
    }

    /**
     * 正常打开新的Activity 动画效果右向左推
     *
     * @param pContext
     * @param pClass
     */
    public void startNewActivityNoraml(Context pContext, Class<?> pClass) {
        startNewActivity(pContext, pClass);
        overridePendingTransition(R.anim.move_push_in, R.anim.move_push_out);
    }

    /**
     * 正常打开新的Activity 动画效果右向左推 带上Intent
     * @param intent
     *
     */
    public void startNewActivityNoramlWithIntent(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.move_push_in, R.anim.move_push_out);
    }

    /**
     * 打开新的Activity 动画效果下向上推
     *
     * @param pContext
     * @param pClass
     */
    public void startNewActivityUp(Context pContext, Class<?> pClass) {
        startNewActivity(pContext, pClass);
        overridePendingTransition(R.anim.move_push_up_in,
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
        startActivity(mIntent);
    }

    //进行关闭当前的Activity
    protected void finish(Context pContext) {
        finish();
        overridePendingTransition(R.anim.move_pop_in, R.anim.move_pop_out);
        ActivityUtils.getInstance().popActivity(this);
    }

    /**
     * 基类发送通知方法封装
     */
    public void sendNotifycation(Class<?> mClass, String mTitle,
                                 String contentTitle, String contentText) {
        // 发送Notification
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.mipmap.ic_launcher,
                mTitle, System.currentTimeMillis());
        Intent intent = new Intent(this, mClass);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, 0);
//       notification.setLatestEventInfo(this, contentTitle, contentText,
//                pendingIntent);

        notification.flags = Notification.FLAG_AUTO_CANCEL;
        manager.notify(0, notification);
    }

    @Override
    public String getTextStr(int viewId) {
        return ((TextView) findViewById(viewId)).getText().toString();
    }

    @Override
    public void setTextStr(int viewId, String str) {
        ((TextView) findViewById(viewId)).setText(str);
    }

    @Override
    public void setBtnClickable(int viewId, boolean isClickable) {
        findViewById(viewId).setClickable(isClickable);
    }

    @Override
    public void setViewVisible(int viewId, int visible) {
        findViewById(viewId).setVisibility(visible);
    }

    @Override
    public void setTextColor(int viewId, int color) {
        ((TextView) findViewById(viewId)).setTextColor(color);
    }

    @Override
    public void showShortToast(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLongToast(String info) {
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressDialog(String info) {
        Log.d("dialog", "显示进度dialog");
        progressDialog = DialogUtils.createProgressDialog(this, info);
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            Log.d("dialog", "隐藏进度dialog");
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void showProgressDialog(int info) {
        Log.d("dialog", "显示进度dialog");
        progressDialog = DialogUtils.createProgressDialog(this, info);
    }


    @Override
    public void showInfoDialog(String btnStr, String info, View.OnClickListener onClickListener) {
        infoDialog = DialogUtils.createInfoDialog(this, btnStr, info, onClickListener);
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
        alertDialog = DialogUtils.createAlertDialog(this, leftBtnStr, rightBtnStr, message, leftOnClickListener, rightOnClickListener);
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
        listDialog = DialogUtils.createListDialog(this, title, list, onItemClickListener);
    }

    @Override
    public void hideListDialog() {
        if (listDialog != null && listDialog.isShowing()) {
            listDialog.dismiss();
            listDialog = null;
        }
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

    public void onEventMainThread(EventMessage eventModel) {

    }


}
