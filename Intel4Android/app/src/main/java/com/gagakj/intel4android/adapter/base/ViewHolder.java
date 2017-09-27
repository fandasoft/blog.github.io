package com.gagakj.intel4android.adapter.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private SparseArray<View> mViews;

    private int mPosition;
    private View mConvertView;

    private ViewHolder(Context context, ViewGroup parent, int layouId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();

        mConvertView = LayoutInflater.from(context).inflate(layouId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 获得ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layouId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layouId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layouId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }


    //--------------View相关方法----------------------------//

    /**
     * 给id为viewId的View设置可见性
     *
     * @param viewId
     * @param visible
     * @return
     */
    public ViewHolder setVisible(int viewId, int visible) {
        View view = getView(viewId);
        view.setVisibility(visible);
        return this;
    }

    /**
     * 给id为viewId的View设置背景
     *
     * @param viewId
     * @param drawable
     * @return
     */
    public ViewHolder setBackground(int viewId, Drawable drawable) {
        View view = getView(viewId);
        view.setBackgroundDrawable(drawable);
        return this;
    }

    /**
     * 给id为viewId的View设置背景
     *
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setBackground(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }


    //--------------TextView相关方法----------------------------//

    /**
     * 给id为viewId的的TextView设置文本
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //--------------ImageView相关方法----------------------------//

    /**
     * 给id为viewId的的ImageView设置图片
     *
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 给id为viewId的的ImageView设置图片
     *
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    /**
     * 给id为viewId的的ImageView设置图片
     *
     * @param viewId
     * @param drawable
     * @return
     */
    public ViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView iv = getView(viewId);
        iv.setImageDrawable(drawable);
        return this;
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param onClickListener
     * @return
     */
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        View iv = getView(viewId);
        iv.setOnClickListener(onClickListener);
        return this;
    }


}
