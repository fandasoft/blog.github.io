package com.gagakj.intel4android.view;

/**
 * Created by admin on 2016/5/6.
 */
public interface IBaseView {
    /**
     * 获取对应ID的输入内容
     *
     * @param viewId 控件ID
     * @return
     */
    String getTextStr(int viewId);

    /**
     * 设置对应ID的TextView系列控件的内容
     *
     * @param viewId 控件ID
     * @param str    内容
     */
    void setTextStr(int viewId, String str);

    /**
     * 设置对应ID的Button系列控件的点击状态
     *
     * @param viewId      控件ID
     * @param isClickable 是否可点击
     */
    void setBtnClickable(int viewId, boolean isClickable);


    void setViewVisible(int viewId, int visible);

    void setTextColor(int viewId, int color);

}
