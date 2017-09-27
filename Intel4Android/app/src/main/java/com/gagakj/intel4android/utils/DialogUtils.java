package com.gagakj.intel4android.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.gagakj.intel4android.R;

import java.util.List;


public class DialogUtils {
    /**
     *
     * @param context
     * @param info
     * @return
     */
    public static ProgressDialog createProgressDialog(Context context,String info){
        ProgressDialog progressDialog =  new ProgressDialog(context);
        progressDialog.setMessage(info);
        progressDialog.show();
        return  progressDialog;
    }

    /**
     * 信息提示窗口
     *
     * @param context
     * @param message
     * @param onConfirmBtnClicked
     * @return
     */
    public static AlertDialog createInfoDialog(Context context, String btnStr, String message, OnClickListener onConfirmBtnClicked) {
        if (context == null) {
            return null;
        } else {
            final AlertDialog dlg = new AlertDialog.Builder(context).create();
            dlg.setCanceledOnTouchOutside(false);
            dlg.show();
            dlg.setContentView(R.layout.dialog_info_layout);
            Button confirmBt = (Button) dlg.findViewById(R.id.dialog_info_confirm_bt);
            TextView messageText = (TextView) dlg.findViewById(R.id.dialog_info_message);
            confirmBt.setText(btnStr);
            messageText.setText(message);
            confirmBt.setOnClickListener(onConfirmBtnClicked);
            return dlg;
        }
    }

    /**
     * 弹出确认窗口
     *
     * @param context
     * @param leftBtnStr
     * @param rightBtnStr
     * @param message
     * @param leftOnClickListener
     * @param rightOnClickListener
     * @return
     */
    public static AlertDialog createAlertDialog(Context context, String leftBtnStr, String rightBtnStr, String message, OnClickListener leftOnClickListener, OnClickListener rightOnClickListener) {
        if (context == null) {
            return null;
        } else {
            final AlertDialog dlg = new AlertDialog.Builder(context).create();
            dlg.setCanceledOnTouchOutside(false);
            dlg.show();
            dlg.setContentView(R.layout.dialog_layout);
            Button leftBtn = (Button) dlg.findViewById(R.id.dialog_left_btn);
            Button rightBtn = (Button) dlg.findViewById(R.id.dialog_right_btn);
            TextView messageText = (TextView) dlg.findViewById(R.id.dialog_message);
            if (leftBtnStr == null) {
                leftBtn.setText("");
            } else {
                leftBtn.setText(leftBtnStr);
            }
            if (rightBtnStr == null) {
                rightBtn.setText("");
            } else {
                rightBtn.setText(rightBtnStr);
            }
            messageText.setText(message);
            leftBtn.setOnClickListener(leftOnClickListener);
            if (rightOnClickListener == null) {
                rightBtn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.dismiss();
                    }
                });
            } else {
                rightBtn.setOnClickListener(rightOnClickListener);
            }
            return dlg;
        }
    }

    public static AlertDialog createListDialog(Context context, String title, List<String> list, AdapterView.OnItemClickListener itemClickListener) {
        if (context == null) {
            return null;
        } else {
            final AlertDialog dlg = new AlertDialog.Builder(context).create();
            dlg.setCanceledOnTouchOutside(false);
            dlg.show();
            dlg.setContentView(R.layout.list_dialog_layout);
            ListView listView = (ListView) dlg.findViewById(R.id.list_dialog_list);
            TextView titleTV = (TextView) dlg.findViewById(R.id.title);
            titleTV.setText(title);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.list_dialog_listitem, list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(itemClickListener);
            return dlg;
        }
    }

    /**
     * 单选对话框
     *
     * @param context
     * @param str
     * @param onClickListener
     * @return
     */
    public static AlertDialog createChooseDialog(Context context, String[] str,
                                                 DialogInterface.OnClickListener onClickListener) {
        if (context == null) {
            return null;
        } else {
            AlertDialog dlg = new AlertDialog.Builder(context).setItems(str, onClickListener).create();
            return dlg;
        }
    }

    /*
       * 选择分享平台dialog
       */
    public static AlertDialog createSelectPlatform(Context context, OnClickListener confirmClickListener){
        AlertDialog dialog = null;
        if (context == null) {
            return null;
        } else {
            dialog = new AlertDialog.Builder(context).create();
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
            View contentView = LayoutInflater.from(context).inflate(R.layout.select_plat_dialog_layout, null);
            contentView.findViewById(R.id.relative_wx_haoyou).setOnClickListener(confirmClickListener);
            contentView.findViewById(R.id.relative_wx_circle).setOnClickListener(confirmClickListener);
//            contentView.findViewById(R.id.bt_confirm_dialog_cancel).setOnClickListener(confirmClickListener);
            Window window = dialog.getWindow();
            window.setWindowAnimations(R.style.animation_confirm_dialog_window);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = StrUtils.dip2px(context, 280);
            lp.height = StrUtils.dip2px(context, 200);
            window.setAttributes(lp);
            dialog.setContentView(contentView);
        }
        return dialog;
    }
    public static AlertDialog createAnotherPlaceDialog(Context context, String leftBtnStr, String rightBtnStr, String message, OnClickListener leftOnClickListener, OnClickListener rightOnClickListener) {
        if (context == null) {
            return null;
        } else {
            final AlertDialog dlg = new AlertDialog.Builder(context).create();
            dlg.setCanceledOnTouchOutside(false);
            dlg.setCancelable(false);
            dlg.show();
            dlg.setContentView(R.layout.dialog_layout);
            Button leftBtn = (Button) dlg.findViewById(R.id.dialog_left_btn);
            Button rightBtn = (Button) dlg.findViewById(R.id.dialog_right_btn);
            TextView messageText = (TextView) dlg.findViewById(R.id.dialog_message);
            if (leftBtnStr == null) {
                leftBtn.setText("");
            } else {
                leftBtn.setText(leftBtnStr);
            }
            if (rightBtnStr == null) {
                rightBtn.setText("");
            } else {
                rightBtn.setText(rightBtnStr);
            }
            messageText.setText(message);
            leftBtn.setOnClickListener(leftOnClickListener);
            if (rightOnClickListener == null) {
                rightBtn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.dismiss();
                    }
                });
            } else {
                rightBtn.setOnClickListener(rightOnClickListener);
            }
            return dlg;
        }
    }

    /**
     * 根据应用上下文和显示的信息 新型创建显示进度框
     *
     * @param pContext
     * @param info
     * @return 进度框
     */
    public static ProgressDialog createProgressDialog(Context pContext, int info) {
        if (pContext == null) {
            return null;
        } else {
            ProgressDialog mProgressDialog = new ProgressDialog(pContext);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setProgressStyle(R.style.CustomDialog);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.mid_progress_dialog_layout);
            TextView tv_info = (TextView) mProgressDialog
                    .findViewById(R.id.progress_tv_info);
            tv_info.setText(info);
            return mProgressDialog;
        }
    }
}
