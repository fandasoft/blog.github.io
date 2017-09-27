package com.gagakj.intel4android.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gagakj.intel4android.R;
import com.gagakj.intel4android.bean.TaskBoxListInfo;
import com.gagakj.intel4android.common.Constants;

import java.util.List;

/**
 * Created by zhujiaqi on 2017/5/27.
 */

public class TaskBoxAdapter extends BaseAdapter {

    private List<TaskBoxListInfo> taskBoxListInfos ;
    private Context mContext ;
    private LayoutInflater inflater ;
    private int type ;

    public TaskBoxAdapter(Context mContext, List<TaskBoxListInfo> taskBoxListInfos , int type) {
        this.mContext = mContext;
        this.taskBoxListInfos = taskBoxListInfos;
        inflater = LayoutInflater.from(mContext);
        this.type = type ;
    }

    @Override
    public int getCount() {
        return taskBoxListInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return taskBoxListInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        TaskBoxListInfo taskBoxListInfo = taskBoxListInfos.get(position);
        if(null == convertView){
            convertView = inflater.inflate(R.layout.item_taskbox_list , parent , false);
            holder = new ViewHolder();
            holder.tv_taskbox_name = (TextView) convertView.findViewById(R.id.tv_taskbox_name);
            holder.tv_worker_name = (TextView) convertView.findViewById(R.id.tv_worker_name);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_receive = (TextView) convertView.findViewById(R.id.tv_receive);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        initView(holder , taskBoxListInfo ,type);
        return convertView;
    }

    class ViewHolder{
        TextView tv_taskbox_name;
        TextView tv_worker_name;
        TextView tv_time;
        TextView tv_receive;

    }

    private void initView(ViewHolder holder , TaskBoxListInfo boxListInfo  , int type){
        holder.tv_taskbox_name.setText(boxListInfo.getTaskName());
        holder.tv_worker_name.setText(boxListInfo.getWorkerName());
        holder.tv_time.setText(boxListInfo.getTime());
        if(type == Constants.WAITING_TASK){
            holder.tv_receive.setVisibility(View.VISIBLE);
        }else{
            holder.tv_receive.setVisibility(View.INVISIBLE);
        }

    }
}
