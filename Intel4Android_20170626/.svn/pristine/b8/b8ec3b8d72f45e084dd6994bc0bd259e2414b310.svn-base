package com.gagakj.intel4android.adapter.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gagakj.intel4android.base.BaseFragment;

import java.util.List;


/**
 * 当前类注释:
 * 项目名：NightLive4Android
 * 包名：com.gagakj.nightlive.adapter.base
 * 作者：江清清 on 2016/12/2 22:50
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> list;

    public void setList(List<BaseFragment> list) {
        this.list = list;
    }
    private String[] titles;
    private LayoutInflater mInflater;
    public void setTitles(String[] titles) {
        this.titles = titles;
    }
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment=null;
        try {
            fragment=(Fragment)super.instantiateItem(container,position);
        }catch (Exception e){

        }
        return fragment;
    }


    public void destroyItem(ViewGroup container, int position, Object object) {

    }
    //此方法用来显示tab上的名字
    public CharSequence getPageTitle(int position) {

        return titles[position %titles.length];
    }
}
