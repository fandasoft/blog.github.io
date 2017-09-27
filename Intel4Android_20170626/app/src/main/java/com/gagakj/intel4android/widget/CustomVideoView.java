package com.gagakj.intel4android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * 当前类注释:自定义VideoView
 * 项目名：NightLive4Android
 * 包名：com.gagakj.nightlive.widget
 * 作者：江清清 on 2017/1/19 21:05
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */


public class CustomVideoView extends VideoView {

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
