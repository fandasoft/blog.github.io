package com.gagakj.intel4android.network.model;

/**
 * 当前类注释:取消任务
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.network.model
 * 作者：江清清 on 2017/6/25 19:53
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */


public class RefuseToTaskResponse implements IModel {
    /**
     * success : true
     * msg : 认领任务成功!
     */

    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
