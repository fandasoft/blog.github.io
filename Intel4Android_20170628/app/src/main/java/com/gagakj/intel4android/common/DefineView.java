package com.gagakj.intel4android.common;

/**
 * 所有的Activity,Fragment可以实现这个接口，来进行一些公关的操作
 * @author apple
 *
 */
public interface DefineView {
   public void initView();  //初始化界面元素
   public void initValidata();  //初始化变量
   public void initListener();  //初始化监听器
   public void bindData();       //绑定数据
   public void initAdapter();//初始化适配器
}
