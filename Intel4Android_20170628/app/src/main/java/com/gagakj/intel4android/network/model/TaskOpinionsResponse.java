package com.gagakj.intel4android.network.model;

import java.util.List;

/**
 * 当前类注释:
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.network.model
 * 作者：江清清 on 2017/6/20 14:31
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */

public class TaskOpinionsResponse implements IModel {

    /**
     * results : [{"actDefId":"EPONzyOLTyslcV2:1:10000009860318","actInstId":"10000010470485","candidateUser":"","candidateUserStatusList":[],"candidateUsers":[],"checkStatus":-1,"createBy":0,"createtime":null,"deviceType":"Computer","deviceTypeStr":"电脑","durTime":0,"durTimeStr":"","endTime":null,"endTimeStr":"","exeFullname":"超级管理员","exeUserId":1,"fieldName":"","formDefId":0,"opinion":"","opinionId":10000010470535,"startTime":{"date":20,"day":2,"hours":13,"minutes":38,"month":5,"seconds":26,"time":1497937106229,"timezoneOffset":-480,"year":117},"startTimeStr":"2017-06-20 13:38:26","status":"正在审批","superExecution":"","taskExeStatus":null,"taskId":10000010470534,"taskKey":"UserTask1","taskName":"智能挂测","taskToken":"","updateBy":0,"updatetime":null,"userAgent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36"},{"actDefId":"EPONzyOLTyslcV2:1:10000009860318","actInstId":"10000010470485","candidateUser":"","candidateUserStatusList":[],"candidateUsers":[],"checkStatus":33,"createBy":0,"createtime":null,"deviceType":"Computer","deviceTypeStr":"电脑","durTime":1646,"durTimeStr":"1秒646毫秒","endTime":{"date":20,"day":2,"hours":13,"minutes":38,"month":5,"seconds":26,"time":1497937106181,"timezoneOffset":-480,"year":117},"endTimeStr":"2017-06-20 13:38:26","exeFullname":"超级管理员","exeUserId":1,"fieldName":"","formDefId":0,"opinion":"","opinionId":10000010470516,"startTime":{"date":20,"day":2,"hours":13,"minutes":38,"month":5,"seconds":24,"time":1497937104535,"timezoneOffset":-480,"year":117},"startTimeStr":"2017-06-20 13:38:24","status":"提交","superExecution":"","taskExeStatus":null,"taskId":10000010470515,"taskKey":"task1","taskName":"建设单位发起","taskToken":"","updateBy":0,"updatetime":null,"userAgent":"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36"}]
     * totalCounts : 2
     */

    private int totalCounts;
    private List<ResultsBean> results;

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * actDefId : EPONzyOLTyslcV2:1:10000009860318
         * actInstId : 10000010470485
         * candidateUser :
         * candidateUserStatusList : []
         * candidateUsers : []
         * checkStatus : -1
         * createBy : 0
         * createtime : null
         * deviceType : Computer
         * deviceTypeStr : 电脑
         * durTime : 0
         * durTimeStr :
         * endTime : null
         * endTimeStr :
         * exeFullname : 超级管理员
         * exeUserId : 1
         * fieldName :
         * formDefId : 0
         * opinion :
         * opinionId : 10000010470535
         * startTime : {"date":20,"day":2,"hours":13,"minutes":38,"month":5,"seconds":26,"time":1497937106229,"timezoneOffset":-480,"year":117}
         * startTimeStr : 2017-06-20 13:38:26
         * status : 正在审批
         * superExecution :
         * taskExeStatus : null
         * taskId : 10000010470534
         * taskKey : UserTask1
         * taskName : 智能挂测
         * taskToken :
         * updateBy : 0
         * updatetime : null
         * userAgent : Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36
         */

        private String actDefId;
        private String actInstId;
        private String candidateUser;
        private int checkStatus;
        private int createBy;
        private Object createtime;
        private String deviceType;
        private String deviceTypeStr;
        private int durTime;
        private String durTimeStr;
        private Object endTime;
        private String endTimeStr;
        private String exeFullname;
        private int exeUserId;
        private String fieldName;
        private int formDefId;
        private String opinion;
        private long opinionId;
        private StartTimeBean startTime;
        private String startTimeStr;
        private String status;
        private String superExecution;
        private Object taskExeStatus;
        private long taskId;
        private String taskKey;
        private String taskName;
        private String taskToken;
        private int updateBy;
        private Object updatetime;
        private String userAgent;
        private List<?> candidateUserStatusList;
        private List<?> candidateUsers;

        public String getActDefId() {
            return actDefId;
        }

        public void setActDefId(String actDefId) {
            this.actDefId = actDefId;
        }

        public String getActInstId() {
            return actInstId;
        }

        public void setActInstId(String actInstId) {
            this.actInstId = actInstId;
        }

        public String getCandidateUser() {
            return candidateUser;
        }

        public void setCandidateUser(String candidateUser) {
            this.candidateUser = candidateUser;
        }

        public int getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(int checkStatus) {
            this.checkStatus = checkStatus;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public Object getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Object createtime) {
            this.createtime = createtime;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceTypeStr() {
            return deviceTypeStr;
        }

        public void setDeviceTypeStr(String deviceTypeStr) {
            this.deviceTypeStr = deviceTypeStr;
        }

        public int getDurTime() {
            return durTime;
        }

        public void setDurTime(int durTime) {
            this.durTime = durTime;
        }

        public String getDurTimeStr() {
            return durTimeStr;
        }

        public void setDurTimeStr(String durTimeStr) {
            this.durTimeStr = durTimeStr;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getEndTimeStr() {
            return endTimeStr;
        }

        public void setEndTimeStr(String endTimeStr) {
            this.endTimeStr = endTimeStr;
        }

        public String getExeFullname() {
            return exeFullname;
        }

        public void setExeFullname(String exeFullname) {
            this.exeFullname = exeFullname;
        }

        public int getExeUserId() {
            return exeUserId;
        }

        public void setExeUserId(int exeUserId) {
            this.exeUserId = exeUserId;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public int getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(int formDefId) {
            this.formDefId = formDefId;
        }

        public String getOpinion() {
            return opinion;
        }

        public void setOpinion(String opinion) {
            this.opinion = opinion;
        }

        public long getOpinionId() {
            return opinionId;
        }

        public void setOpinionId(long opinionId) {
            this.opinionId = opinionId;
        }

        public StartTimeBean getStartTime() {
            return startTime;
        }

        public void setStartTime(StartTimeBean startTime) {
            this.startTime = startTime;
        }

        public String getStartTimeStr() {
            return startTimeStr;
        }

        public void setStartTimeStr(String startTimeStr) {
            this.startTimeStr = startTimeStr;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSuperExecution() {
            return superExecution;
        }

        public void setSuperExecution(String superExecution) {
            this.superExecution = superExecution;
        }

        public Object getTaskExeStatus() {
            return taskExeStatus;
        }

        public void setTaskExeStatus(Object taskExeStatus) {
            this.taskExeStatus = taskExeStatus;
        }

        public long getTaskId() {
            return taskId;
        }

        public void setTaskId(long taskId) {
            this.taskId = taskId;
        }

        public String getTaskKey() {
            return taskKey;
        }

        public void setTaskKey(String taskKey) {
            this.taskKey = taskKey;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskToken() {
            return taskToken;
        }

        public void setTaskToken(String taskToken) {
            this.taskToken = taskToken;
        }

        public int getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(int updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }

        public List<?> getCandidateUserStatusList() {
            return candidateUserStatusList;
        }

        public void setCandidateUserStatusList(List<?> candidateUserStatusList) {
            this.candidateUserStatusList = candidateUserStatusList;
        }

        public List<?> getCandidateUsers() {
            return candidateUsers;
        }

        public void setCandidateUsers(List<?> candidateUsers) {
            this.candidateUsers = candidateUsers;
        }

        public static class StartTimeBean {
            /**
             * date : 20
             * day : 2
             * hours : 13
             * minutes : 38
             * month : 5
             * seconds : 26
             * time : 1497937106229
             * timezoneOffset : -480
             * year : 117
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
