package com.gagakj.intel4android.network.interfaces;

import com.gagakj.intel4android.network.model.AlreadyMattersGcResponse;
import com.gagakj.intel4android.network.model.AlreadyMattersResponse;
import com.gagakj.intel4android.network.model.OltInfoListResponse;
import com.gagakj.intel4android.network.model.PendingMattersGcResponse;
import com.gagakj.intel4android.network.model.PendingMattersResponse;
import com.gagakj.intel4android.network.model.RecTodoListGcResponse;
import com.gagakj.intel4android.network.model.RecTodoListsMattersResponse;
import com.gagakj.intel4android.network.model.RecTodoTaskResponse;
import com.gagakj.intel4android.network.model.TaskFormResponse;
import com.gagakj.intel4android.network.model.TaskOpinionsResponse;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 当前类注释:网络请求接口
 * 项目名：Ssds4Android
 * 包名：com.gagakj.ssds4android.network.interfaces
 * 作者：江清清 on 2017/4/27 15:07
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */


public interface INetInterface {

    /**
     * 待办列表
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/recTodoList.do")
    Observable<RecTodoListsMattersResponse> recTodoListMatters(@QueryMap HashMap<String, String> params);


    /**
     * 在办列表
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/pendingMatters.do")
    Observable<PendingMattersResponse> pendingMatters(@QueryMap HashMap<String, String> params);

    /**
     * 已办列表
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/alreadyMatters.do")
    Observable<AlreadyMattersResponse> alreadyMatters(@QueryMap HashMap<String, String> params);


    /**
     * OLT信息列表
     * @param params
     * @return
     */
    @GET("zhys/epon/mobile/getOltInfoList.do")
    Observable<OltInfoListResponse> oltInfoList(@QueryMap HashMap<String, String> params);

    /**
     * 待办列表-挂测
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/recTodoList.do")
    Observable<RecTodoListGcResponse> recTodoListMattersGc(@QueryMap HashMap<String, String> params);


    /**
     * 在办列表-挂测
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/pendingMatters.do")
    Observable<PendingMattersGcResponse> pendingMattersGc(@QueryMap HashMap<String, String> params);

    /**
     * 已办列表-挂测
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/alreadyMatters.do")
    Observable<AlreadyMattersGcResponse> alreadyMattersGc(@QueryMap HashMap<String, String> params);

    /**
     * 获取工程信息
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/getTaskForm.do")
    Observable<TaskFormResponse> taskFrom(@QueryMap HashMap<String, String> params);

    /**
     * 领取任务
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/recTodoTask.do")
    Observable<RecTodoTaskResponse> recTodoTask(@QueryMap HashMap<String, String> params);

    /**
     * 获取处理历史
     * @param params
     * @return
     */
    @GET("mobile/bpm/bpmMobileTask/taskOpinions.do")
    Observable<TaskOpinionsResponse> taskOpinions(@QueryMap HashMap<String, String> params);
}

