package com.gagakj.intel4android.adapter.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.gagakj.intel4android.bean.FragmentInfo;
import java.util.ArrayList;


/**
 * Created by zhujiaqi on 2017/4/13.
 */

public class TaskStatusAdapter extends FragmentStatePagerAdapter {

    ArrayList<FragmentInfo> mfragmentList  ;
    public TaskStatusAdapter(FragmentManager fm  , ArrayList<FragmentInfo> mfragmentList) {
        super(fm);
        this.mfragmentList = mfragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mfragmentList.get(position).getTitle();
    }
}
