package com.gagakj.intel4android.network.model;

import java.util.List;

/**
 * 当前类注释:挂测-已办列表返回信息实体类
 * 项目名：Intel4Android
 * 包名：com.gagakj.intel4android.network.model
 * 作者：江清清 on 2017/6/16 13:29
 * 邮箱：jiangqq@gagakj.com
 * QQ： 781931404
 * 公司：南通嘎嘎软件科技有限公司
 * 站点:<a href="http://www.gagakj.com">www.gagakj.com</a>
 */
public class AlreadyMattersGcResponse implements IModel {

    /**
     * results : [{"actDefId":"eponzykglc:1:10000003830004","actInstId":"10000010450903","allowBackToStart":false,"allowFinishedDivert":1,"authorizeRight":null,"busDescp":"","businessKey":"10000010450899","businessUrl":"/zhys/epon/start/get.do?id={businessKey}","copyId":0,"createBy":0,"createtime":{"date":15,"day":4,"hours":19,"minutes":42,"month":5,"seconds":20,"time":1497526940000,"timezoneOffset":-480,"year":117},"creator":"超级管理员","creatorId":1,"defId":10000003830000,"dsAlias":"","duration":31074,"endTime":{"date":15,"day":4,"hours":19,"minutes":42,"month":5,"seconds":51,"time":1497526971000,"timezoneOffset":-480,"year":117},"flowKey":"eponzykglc","formDefId":0,"formKeyUrl":"","formType":0,"grade":1,"isFormal":1,"isPrintForm":0,"lastSubmitDuration":0,"orgName":"","parentId":0,"pkName":"","processName":"EPON专业开工流程","recover":0,"runId":10000010450897,"startNode":"","startOrgId":10000000700051,"startOrgName":"工程部","status":2,"subject":"EPON专业开工流程-gc002(gc002)-超级管理员-2017-06-15 19:42:21","tableName":"","tagids":"","typeId":10000000740006,"typeName":"","updateBy":0,"updatetime":null},{"actDefId":"eponzykglc:1:10000003830004","actInstId":"10000009860331","allowBackToStart":false,"allowFinishedDivert":1,"authorizeRight":null,"busDescp":"","businessKey":"10000009860327","businessUrl":"/zhys/epon/start/get.do?id={businessKey}","copyId":0,"createBy":0,"createtime":{"date":23,"day":2,"hours":14,"minutes":20,"month":4,"seconds":28,"time":1495520428000,"timezoneOffset":-480,"year":117},"creator":"超级管理员","creatorId":1,"defId":10000003830000,"dsAlias":"","duration":22360,"endTime":{"date":23,"day":2,"hours":14,"minutes":20,"month":4,"seconds":50,"time":1495520450000,"timezoneOffset":-480,"year":117},"flowKey":"eponzykglc","formDefId":0,"formKeyUrl":"","formType":0,"grade":1,"isFormal":1,"isPrintForm":0,"lastSubmitDuration":0,"orgName":"","parentId":0,"pkName":"","processName":"EPON专业开工流程","recover":0,"runId":10000009860325,"startNode":"","startOrgId":10000000700051,"startOrgName":"工程部","status":2,"subject":"EPON专业开工流程-OLT0523001(OLT0523001)-超级管理员-2017-05-23 14:20:29","tableName":"","tagids":"","typeId":10000000740006,"typeName":"","updateBy":0,"updatetime":null},{"actDefId":"EponzyONUyslc:1:10000009058928","actInstId":"10000010195848","allowBackToStart":false,"allowFinishedDivert":1,"authorizeRight":null,"busDescp":"","businessKey":"10000010195843","businessUrl":"/zhys/epon/checkOlt/get.do?id={businessKey}","copyId":0,"createBy":0,"createtime":{"date":22,"day":1,"hours":10,"minutes":42,"month":4,"seconds":37,"time":1495420957000,"timezoneOffset":-480,"year":117},"creator":"方斌","creatorId":10000009518021,"defId":10000009058923,"dsAlias":"","duration":0,"endTime":null,"flowKey":"EponzyONUyslc","formDefId":0,"formKeyUrl":"","formType":0,"grade":1,"isFormal":1,"isPrintForm":0,"lastSubmitDuration":0,"orgName":"","parentId":0,"pkName":"","processName":"EPON专业ONU验收流程","recover":0,"runId":10000010195842,"startNode":"","startOrgId":10000000700066,"startOrgName":"西区局","status":1,"subject":"EPON专业ONU验收流程-沙田新苑(16SH000840008)-方斌-2017-05-22 10:42:38","tableName":"","tagids":"","typeId":10000000740006,"typeName":"","updateBy":0,"updatetime":null}]
     * totalCounts : 3
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
         * actDefId : eponzykglc:1:10000003830004
         * actInstId : 10000010450903
         * allowBackToStart : false
         * allowFinishedDivert : 1
         * authorizeRight : null
         * busDescp :
         * businessKey : 10000010450899
         * businessUrl : /zhys/epon/start/get.do?id={businessKey}
         * copyId : 0
         * createBy : 0
         * createtime : {"date":15,"day":4,"hours":19,"minutes":42,"month":5,"seconds":20,"time":1497526940000,"timezoneOffset":-480,"year":117}
         * creator : 超级管理员
         * creatorId : 1
         * defId : 10000003830000
         * dsAlias :
         * duration : 31074
         * endTime : {"date":15,"day":4,"hours":19,"minutes":42,"month":5,"seconds":51,"time":1497526971000,"timezoneOffset":-480,"year":117}
         * flowKey : eponzykglc
         * formDefId : 0
         * formKeyUrl :
         * formType : 0
         * grade : 1
         * isFormal : 1
         * isPrintForm : 0
         * lastSubmitDuration : 0
         * orgName :
         * parentId : 0
         * pkName :
         * processName : EPON专业开工流程
         * recover : 0
         * runId : 10000010450897
         * startNode :
         * startOrgId : 10000000700051
         * startOrgName : 工程部
         * status : 2
         * subject : EPON专业开工流程-gc002(gc002)-超级管理员-2017-06-15 19:42:21
         * tableName :
         * tagids :
         * typeId : 10000000740006
         * typeName :
         * updateBy : 0
         * updatetime : null
         */

        private String actDefId;
        private String actInstId;
        private boolean allowBackToStart;
        private int allowFinishedDivert;
        private Object authorizeRight;
        private String busDescp;
        private String businessKey;
        private String businessUrl;
        private int copyId;
        private int createBy;
        private CreatetimeBean createtime;
        private String creator;
        private long creatorId;
        private long defId;
        private String dsAlias;
        private int duration;
        private EndTimeBean endTime;
        private String flowKey;
        private int formDefId;
        private String formKeyUrl;
        private int formType;
        private int grade;
        private int isFormal;
        private int isPrintForm;
        private int lastSubmitDuration;
        private String orgName;
        private int parentId;
        private String pkName;
        private String processName;
        private int recover;
        private long runId;
        private String startNode;
        private long startOrgId;
        private String startOrgName;
        private int status;
        private String subject;
        private String tableName;
        private String tagids;
        private long typeId;
        private String typeName;
        private int updateBy;
        private Object updatetime;

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

        public boolean isAllowBackToStart() {
            return allowBackToStart;
        }

        public void setAllowBackToStart(boolean allowBackToStart) {
            this.allowBackToStart = allowBackToStart;
        }

        public int getAllowFinishedDivert() {
            return allowFinishedDivert;
        }

        public void setAllowFinishedDivert(int allowFinishedDivert) {
            this.allowFinishedDivert = allowFinishedDivert;
        }

        public Object getAuthorizeRight() {
            return authorizeRight;
        }

        public void setAuthorizeRight(Object authorizeRight) {
            this.authorizeRight = authorizeRight;
        }

        public String getBusDescp() {
            return busDescp;
        }

        public void setBusDescp(String busDescp) {
            this.busDescp = busDescp;
        }

        public String getBusinessKey() {
            return businessKey;
        }

        public void setBusinessKey(String businessKey) {
            this.businessKey = businessKey;
        }

        public String getBusinessUrl() {
            return businessUrl;
        }

        public void setBusinessUrl(String businessUrl) {
            this.businessUrl = businessUrl;
        }

        public int getCopyId() {
            return copyId;
        }

        public void setCopyId(int copyId) {
            this.copyId = copyId;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public CreatetimeBean getCreatetime() {
            return createtime;
        }

        public void setCreatetime(CreatetimeBean createtime) {
            this.createtime = createtime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public long getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public long getDefId() {
            return defId;
        }

        public void setDefId(long defId) {
            this.defId = defId;
        }

        public String getDsAlias() {
            return dsAlias;
        }

        public void setDsAlias(String dsAlias) {
            this.dsAlias = dsAlias;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public EndTimeBean getEndTime() {
            return endTime;
        }

        public void setEndTime(EndTimeBean endTime) {
            this.endTime = endTime;
        }

        public String getFlowKey() {
            return flowKey;
        }

        public void setFlowKey(String flowKey) {
            this.flowKey = flowKey;
        }

        public int getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(int formDefId) {
            this.formDefId = formDefId;
        }

        public String getFormKeyUrl() {
            return formKeyUrl;
        }

        public void setFormKeyUrl(String formKeyUrl) {
            this.formKeyUrl = formKeyUrl;
        }

        public int getFormType() {
            return formType;
        }

        public void setFormType(int formType) {
            this.formType = formType;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getIsFormal() {
            return isFormal;
        }

        public void setIsFormal(int isFormal) {
            this.isFormal = isFormal;
        }

        public int getIsPrintForm() {
            return isPrintForm;
        }

        public void setIsPrintForm(int isPrintForm) {
            this.isPrintForm = isPrintForm;
        }

        public int getLastSubmitDuration() {
            return lastSubmitDuration;
        }

        public void setLastSubmitDuration(int lastSubmitDuration) {
            this.lastSubmitDuration = lastSubmitDuration;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getPkName() {
            return pkName;
        }

        public void setPkName(String pkName) {
            this.pkName = pkName;
        }

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public int getRecover() {
            return recover;
        }

        public void setRecover(int recover) {
            this.recover = recover;
        }

        public long getRunId() {
            return runId;
        }

        public void setRunId(long runId) {
            this.runId = runId;
        }

        public String getStartNode() {
            return startNode;
        }

        public void setStartNode(String startNode) {
            this.startNode = startNode;
        }

        public long getStartOrgId() {
            return startOrgId;
        }

        public void setStartOrgId(long startOrgId) {
            this.startOrgId = startOrgId;
        }

        public String getStartOrgName() {
            return startOrgName;
        }

        public void setStartOrgName(String startOrgName) {
            this.startOrgName = startOrgName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getTagids() {
            return tagids;
        }

        public void setTagids(String tagids) {
            this.tagids = tagids;
        }

        public long getTypeId() {
            return typeId;
        }

        public void setTypeId(long typeId) {
            this.typeId = typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
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

        public static class CreatetimeBean {
            /**
             * date : 15
             * day : 4
             * hours : 19
             * minutes : 42
             * month : 5
             * seconds : 20
             * time : 1497526940000
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

        public static class EndTimeBean {
            /**
             * date : 15
             * day : 4
             * hours : 19
             * minutes : 42
             * month : 5
             * seconds : 51
             * time : 1497526971000
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
