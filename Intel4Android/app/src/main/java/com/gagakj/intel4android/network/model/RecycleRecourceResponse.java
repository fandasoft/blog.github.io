package com.gagakj.intel4android.network.model;

/**
 * 当前类注释:返回挂测结果 -后台同时调用挂测资源回收
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.network.model
 * 作者：江清清 on 2017/6/27 14:35
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */


public class RecycleRecourceResponse implements IModel {

    /**
     * success : true
     * result : sucess
     * xml : sucess
     * bizOltGcInfo : {"createBy":1,"createby":0,"createtime":{"date":20,"day":2,"hours":13,"minutes":30,"month":5,"seconds":39,"time":1497936639000,"timezoneOffset":-480,"year":117},"id":10000010470307,"obd":"obd8","oltCname":"高东T1-HW5800-OLT05","oltFggl":"","oltId":10000010470275,"oltIp":"","oltSggl":"","onuFggl":"","onuSggl":"","ponPort":"1/19/n/02","pvcWWlan":"","result":"未挂测","updateBy":10000003620083,"updateby":0,"updatetime":{"date":27,"day":2,"hours":14,"minutes":32,"month":5,"seconds":7,"time":1498545127541,"timezoneOffset":-480,"year":117},"wWlan":"132"}
     */

    private boolean success;
    private String result;
    private String xml;
    private BizOltGcInfoBean bizOltGcInfo;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public BizOltGcInfoBean getBizOltGcInfo() {
        return bizOltGcInfo;
    }

    public void setBizOltGcInfo(BizOltGcInfoBean bizOltGcInfo) {
        this.bizOltGcInfo = bizOltGcInfo;
    }

    public static class BizOltGcInfoBean {
        /**
         * createBy : 1
         * createby : 0
         * createtime : {"date":20,"day":2,"hours":13,"minutes":30,"month":5,"seconds":39,"time":1497936639000,"timezoneOffset":-480,"year":117}
         * id : 10000010470307
         * obd : obd8
         * oltCname : 高东T1-HW5800-OLT05
         * oltFggl :
         * oltId : 10000010470275
         * oltIp :
         * oltSggl :
         * onuFggl :
         * onuSggl :
         * ponPort : 1/19/n/02
         * pvcWWlan :
         * result : 未挂测
         * updateBy : 10000003620083
         * updateby : 0
         * updatetime : {"date":27,"day":2,"hours":14,"minutes":32,"month":5,"seconds":7,"time":1498545127541,"timezoneOffset":-480,"year":117}
         * wWlan : 132
         */

        private int createBy;
        private int createby;
        private CreatetimeBean createtime;
        private long id;
        private String obd;
        private String oltCname;
        private String oltFggl;
        private long oltId;
        private String oltIp;
        private String oltSggl;
        private String onuFggl;
        private String onuSggl;
        private String ponPort;
        private String pvcWWlan;
        private String result;
        private long updateBy;
        private int updateby;
        private UpdatetimeBean updatetime;
        private String wWlan;

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public int getCreateby() {
            return createby;
        }

        public void setCreateby(int createby) {
            this.createby = createby;
        }

        public CreatetimeBean getCreatetime() {
            return createtime;
        }

        public void setCreatetime(CreatetimeBean createtime) {
            this.createtime = createtime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getObd() {
            return obd;
        }

        public void setObd(String obd) {
            this.obd = obd;
        }

        public String getOltCname() {
            return oltCname;
        }

        public void setOltCname(String oltCname) {
            this.oltCname = oltCname;
        }

        public String getOltFggl() {
            return oltFggl;
        }

        public void setOltFggl(String oltFggl) {
            this.oltFggl = oltFggl;
        }

        public long getOltId() {
            return oltId;
        }

        public void setOltId(long oltId) {
            this.oltId = oltId;
        }

        public String getOltIp() {
            return oltIp;
        }

        public void setOltIp(String oltIp) {
            this.oltIp = oltIp;
        }

        public String getOltSggl() {
            return oltSggl;
        }

        public void setOltSggl(String oltSggl) {
            this.oltSggl = oltSggl;
        }

        public String getOnuFggl() {
            return onuFggl;
        }

        public void setOnuFggl(String onuFggl) {
            this.onuFggl = onuFggl;
        }

        public String getOnuSggl() {
            return onuSggl;
        }

        public void setOnuSggl(String onuSggl) {
            this.onuSggl = onuSggl;
        }

        public String getPonPort() {
            return ponPort;
        }

        public void setPonPort(String ponPort) {
            this.ponPort = ponPort;
        }

        public String getPvcWWlan() {
            return pvcWWlan;
        }

        public void setPvcWWlan(String pvcWWlan) {
            this.pvcWWlan = pvcWWlan;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public long getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(long updateBy) {
            this.updateBy = updateBy;
        }

        public int getUpdateby() {
            return updateby;
        }

        public void setUpdateby(int updateby) {
            this.updateby = updateby;
        }

        public UpdatetimeBean getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(UpdatetimeBean updatetime) {
            this.updatetime = updatetime;
        }

        public String getWWlan() {
            return wWlan;
        }

        public void setWWlan(String wWlan) {
            this.wWlan = wWlan;
        }

        public static class CreatetimeBean {
            /**
             * date : 20
             * day : 2
             * hours : 13
             * minutes : 30
             * month : 5
             * seconds : 39
             * time : 1497936639000
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

        public static class UpdatetimeBean {
            /**
             * date : 27
             * day : 2
             * hours : 14
             * minutes : 32
             * month : 5
             * seconds : 7
             * time : 1498545127541
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
