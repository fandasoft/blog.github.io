package com.gagakj.intel4android.bean;

/**
 * Created by zhujiaqi on 2017/5/27.
 */

public class TaskBoxListInfo {
    private String taskName ;
    private String workerName ;
    private String time ;


    public TaskBoxListInfo(String taskName, String time, String workerName) {
        this.taskName = taskName;
        this.time = time;
        this.workerName = workerName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public String toString() {
        return "TaskBoxListInfo{" +
                "taskName='" + taskName + '\'' +
                ", workerName='" + workerName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
