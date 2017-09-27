package com.gagakj.intel4android.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter{
	private Context mContext;
	private List<T> mDatas;
	private int mItemLayout;
	/**
	 * 
	 * @param mContext		上下文对象
	 * @param mDatas		数据集
	 * @param itemLayout	item的布局
	 */
	public CommonAdapter(Context mContext, List<T> mDatas, int itemLayout) {
		super();
		this.mContext = mContext;
		this.mDatas = mDatas;
		this.mItemLayout = itemLayout;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int arg0) {
		return mDatas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder= ViewHolder.get(mContext, convertView, parent, mItemLayout, position);
		convert(holder,getItem(position));
		return holder.getConvertView();
	}

	public abstract void convert(ViewHolder holder, T item);

}
