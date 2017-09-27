package com.gagakj.intel4android.view;

import android.view.View;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by admin on 2016/5/6.
 */
public interface IDialogView {
    /**
     * 短吐司
     *
     * @param info
     */
    void showShortToast(String info);

    /**
     * 长吐司
     * @param info
     */
    void showLongToast(String info);

    /**
     * 显示进度对话框
     * @param info
     */
    void showProgressDialog(String info);

    /**
     * 隐藏进度对话框
     */
    void hideProgressDialog();

    /**
     * 显示提示对话框
     * @param btnStr
     * @param info
     * @param onClickListener
     */
    void showInfoDialog(String btnStr, String info, View.OnClickListener onClickListener);

    /**
     * 隐藏提示对话框
     */
    void hideInfoDialog();

    /**
     * 显示对话框（两按钮）
     * @param leftBtnStr
     * @param rightBtnStr
     * @param message
     * @param leftOnClickListener
     * @param rightOnClickListener
     */
    void showAlertDialog(String leftBtnStr, String rightBtnStr, String message, View.OnClickListener leftOnClickListener, View.OnClickListener rightOnClickListener);

    /**
     * 隐藏对话框
     */
    void hideAlertDialog();

    void showListDialog(List<String> list, String title, AdapterView.OnItemClickListener onItemClickListener) ;
    void hideListDialog();
}
