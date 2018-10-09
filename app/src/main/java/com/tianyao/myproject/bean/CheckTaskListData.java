package com.tianyao.myproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 陆维淋
 * on 2018/9/13
 */
public class CheckTaskListData implements Serializable {

    /**
     * totalCount : 73
     * pageSize : 10
     * list : [{"taskFinishedBy":"SYSTEM","taskType":1,"shipName":"粤英德货2238","aisLatitude":23.189488,"shipMmsi":"413905874","id":2512,"lastUpdatedAt":1536413472755,"taskFinishedRemark":"系统自动结束任务","createdAt":1536413472755,"aisLongitude":112.803017,"taskDescribe":"test2","taskFinishedByName":"系统","taskFinishedAt":1536421500436,"shipId":"CN20132130544","executor":"test2","taskRemark":"连续航行作业时间超过8小时，须增加驾驶员1人。","organizationCode":"092402","guid":"RUlBUlUUg5UNsJttBcwop2","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180908-CN20132130544-01","creatorType":"GDMSAEC"},{"taskFinishedBy":"SYSTEM","taskType":1,"shipName":"粤运盈666","aisLatitude":22.703432,"shipMmsi":"413901783","id":2406,"lastUpdatedAt":1535905695423,"taskFinishedRemark":"系统自动结束任务","createdAt":1535905695423,"aisLongitude":113.486343,"taskFinishedByName":"系统","taskFinishedAt":1535913000188,"shipId":"CN20104781479","executor":"测试666","organizationCodeChinese":"智慧海事处","taskRemark":"连续航行作业时间超过16小时，须增加三副1人","organizationCode":"092402","guid":"kFklVR4hg80x1wwhEcIN00","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180903-CN20104781479-01","creatorType":"GDMSAEC"},{"taskFinishedBy":"SYSTEM","taskType":1,"shipName":"振兴和谐","aisLatitude":22.362537,"shipMmsi":"413555810","id":2402,"lastUpdatedAt":1535905465032,"taskFinishedRemark":"系统自动结束任务","createdAt":1535905465032,"aisLongitude":113.78492,"taskDescribe":"test","taskFinishedByName":"系统","taskFinishedAt":1535913000188,"shipId":"CN20159768141","executor":"测试666","organizationCodeChinese":"智慧海事处","taskRemark":"1.国际航行船舶配备高级值班水手2人，值班水手1人；\n2.连续航行时间不超过36小时,可减免三副和值班水手各1人。","organizationCode":"092402","guid":"MYootNNJgx84sY55Ys1x82","creatorName":"智慧海事平台","waterType":"SEA","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180903-CN20159768141-01","creatorType":"GDMSAEC"},{"taskFinishedBy":"SYSTEM","taskType":1,"shipName":"桂平宏远8288","aisLatitude":22.399372,"shipMmsi":"413998127","id":2398,"lastUpdatedAt":1535905060213,"taskFinishedRemark":"系统自动结束任务","createdAt":1535905060213,"aisLongitude":113.256104,"taskDescribe":"test","taskFinishedByName":"系统","taskFinishedAt":1535913000188,"shipId":"CN20152662724","executor":"test111","taskRemark":"连续航行作业时间超过16小时，须增加驾驶员1人；连续航行作业时间不超过8小时或定线航行航程不超过100公里的船舶可减免驾驶员1 人。","organizationCode":"092402","guid":"lMMVR0xYh5kUUEkAAl4UU0","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180903-CN20152662724-01","creatorType":"GDMSAEC"},{"taskFinishedBy":"SYSTEM","taskType":1,"shipName":"南南燃油19","aisLatitude":22.580675,"shipMmsi":"413900496","id":2397,"lastUpdatedAt":1535904933908,"taskFinishedRemark":"系统自动结束任务","createdAt":1535904933908,"aisLongitude":113.52301,"taskDescribe":"test","taskFinishedByName":"系统","taskFinishedAt":1535913000188,"shipId":"CN20047521437","executor":"kktest","organizationCodeChinese":"智慧海事处","taskRemark":"连续航行作业时间超过16小时，须增加三副1人","organizationCode":"092402","guid":"8J0JAZB9gQU8lAB5FEVUk1","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180903-CN20047521437-01","creatorType":"GDMSAEC"},{"taskFinishedBy":"SYSTEM","taskType":1,"shipName":"粤广海货9848","aisLatitude":22.429743,"shipMmsi":"413903239","id":2396,"lastUpdatedAt":1535904879327,"taskFinishedRemark":"系统自动结束任务","createdAt":1535904879327,"aisLongitude":113.223358,"taskDescribe":"test","taskFinishedByName":"系统","taskFinishedAt":1535913000188,"shipId":"CN20035600172","executor":"test111","taskRemark":"连续航行作业时间超过16小时，须增加驾驶员1人；连续航行作业时间不超过8小时或定线航行航程不超过100公里的船舶可减免驾驶员1 人。","organizationCode":"092402","guid":"AE81VVkZgAwg8gJMk4kQQ2","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180903-CN20035600172-01","creatorType":"GDMSAEC"},{"taskType":1,"shipName":"粤建航829","aisLatitude":22.889351,"shipMmsi":"412475320","id":2164,"lastUpdatedAt":1534757036101,"createdAt":1534757036101,"aisLongitude":113.096199,"shipId":"CN20106138758","executor":"kktest","organizationCodeChinese":"智慧海事处","taskRemark":"连续航行作业时间超过16小时，须增加三副1人","organizationCode":"092402","guid":"xB4VYkkBgMYYYxdxEU90V3","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180820-CN20106138758-01","creatorType":"GDMSAEC"},{"taskType":1,"shipName":"穗水巴09","aisLatitude":0,"shipMmsi":"413762689","id":1841,"lastUpdatedAt":1533276112547,"createdAt":1533276112547,"aisLongitude":0,"shipId":"CN20109029265","executor":"test1","taskRemark":"连续航行作业时间超过4小时，须增加驾驶员1人","organizationCode":"092402","guid":"Jg4dN4BYgtMgBYEFtZ4As3","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180803-413762689-01","creatorType":"GDMSAEC"},{"taskType":1,"shipName":"润桂639","aisLatitude":23.125341,"shipMmsi":"413903551","id":1840,"lastUpdatedAt":1533275091502,"createdAt":1533275091502,"aisLongitude":112.263573,"taskDescribe":"测试","shipId":"CN20112616568","executor":"测试666","organizationCodeChinese":"智慧海事处","taskRemark":"连续航行作业时间超过8小时，须增加驾驶员1人。","organizationCode":"092402","guid":"YQ11s8tMh8ANlYsNABZJ51","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180803-413903551-01","creatorType":"GDMSAEC"},{"taskType":1,"shipName":"衡泰2286","aisLatitude":0,"shipMmsi":"413975326","id":1834,"lastUpdatedAt":1533216061474,"createdAt":1533216061474,"aisLongitude":0,"shipId":"CN19944611804","executor":"test1","taskRemark":"连续航行作业时间超过8小时，须增加驾驶员1人。","organizationCode":"092402","guid":"U1UEQEIkhQItEBhB9YtAR3","creatorName":"智慧海事平台","waterType":"RIVER","createdBy":"GDMSAEC","taskSubmitStatus":0,"taskFinishStatus":2,"taskNo":"20180802-413975326-01","creatorType":"GDMSAEC"}]
     * currentPage : 1
     * totalPage : 8
     */

    private int totalCount;
    private int pageSize;
    private int currentPage;
    private int totalPage;
    private List<ListBean> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * taskFinishedBy : SYSTEM
         * taskType : 1
         * shipName : 粤英德货2238
         * aisLatitude : 23.189488
         * shipMmsi : 413905874
         * id : 2512
         * lastUpdatedAt : 1536413472755
         * taskFinishedRemark : 系统自动结束任务
         * createdAt : 1536413472755
         * aisLongitude : 112.803017
         * taskDescribe : test2
         * taskFinishedByName : 系统
         * taskFinishedAt : 1536421500436
         * shipId : CN20132130544
         * executor : test2
         * taskRemark : 连续航行作业时间超过8小时，须增加驾驶员1人。
         * organizationCode : 092402
         * guid : RUlBUlUUg5UNsJttBcwop2
         * creatorName : 智慧海事平台
         * waterType : RIVER
         * createdBy : GDMSAEC
         * taskSubmitStatus : 0
         * taskFinishStatus : 2
         * taskNo : 20180908-CN20132130544-01
         * creatorType : GDMSAEC
         * organizationCodeChinese : 智慧海事处
         */

        private String taskFinishedBy;
        private int taskType;
        private String shipName;
        private double aisLatitude;
        private String shipMmsi;
        private int id;
        private long lastUpdatedAt;
        private String taskFinishedRemark;
        private long createdAt;
        private double aisLongitude;
        private String taskDescribe;
        private String taskFinishedByName;
        private long taskFinishedAt;
        private String shipId;
        private String executor;
        private String taskRemark;
        private String organizationCode;
        private String guid;
        private String creatorName;
        private String waterType;
        private String createdBy;
        private int taskSubmitStatus;
        private int taskFinishStatus;
        private String taskNo;
        private String creatorType;
        private String organizationCodeChinese;

        public String getTaskFinishedBy() {
            return taskFinishedBy;
        }

        public void setTaskFinishedBy(String taskFinishedBy) {
            this.taskFinishedBy = taskFinishedBy;
        }

        public int getTaskType() {
            return taskType;
        }

        public void setTaskType(int taskType) {
            this.taskType = taskType;
        }

        public String getShipName() {
            return shipName;
        }

        public void setShipName(String shipName) {
            this.shipName = shipName;
        }

        public double getAisLatitude() {
            return aisLatitude;
        }

        public void setAisLatitude(double aisLatitude) {
            this.aisLatitude = aisLatitude;
        }

        public String getShipMmsi() {
            return shipMmsi;
        }

        public void setShipMmsi(String shipMmsi) {
            this.shipMmsi = shipMmsi;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getLastUpdatedAt() {
            return lastUpdatedAt;
        }

        public void setLastUpdatedAt(long lastUpdatedAt) {
            this.lastUpdatedAt = lastUpdatedAt;
        }

        public String getTaskFinishedRemark() {
            return taskFinishedRemark;
        }

        public void setTaskFinishedRemark(String taskFinishedRemark) {
            this.taskFinishedRemark = taskFinishedRemark;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public double getAisLongitude() {
            return aisLongitude;
        }

        public void setAisLongitude(double aisLongitude) {
            this.aisLongitude = aisLongitude;
        }

        public String getTaskDescribe() {
            return taskDescribe;
        }

        public void setTaskDescribe(String taskDescribe) {
            this.taskDescribe = taskDescribe;
        }

        public String getTaskFinishedByName() {
            return taskFinishedByName;
        }

        public void setTaskFinishedByName(String taskFinishedByName) {
            this.taskFinishedByName = taskFinishedByName;
        }

        public long getTaskFinishedAt() {
            return taskFinishedAt;
        }

        public void setTaskFinishedAt(long taskFinishedAt) {
            this.taskFinishedAt = taskFinishedAt;
        }

        public String getShipId() {
            return shipId;
        }

        public void setShipId(String shipId) {
            this.shipId = shipId;
        }

        public String getExecutor() {
            return executor;
        }

        public void setExecutor(String executor) {
            this.executor = executor;
        }

        public String getTaskRemark() {
            return taskRemark;
        }

        public void setTaskRemark(String taskRemark) {
            this.taskRemark = taskRemark;
        }

        public String getOrganizationCode() {
            return organizationCode;
        }

        public void setOrganizationCode(String organizationCode) {
            this.organizationCode = organizationCode;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
        }

        public String getWaterType() {
            return waterType;
        }

        public void setWaterType(String waterType) {
            this.waterType = waterType;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public int getTaskSubmitStatus() {
            return taskSubmitStatus;
        }

        public void setTaskSubmitStatus(int taskSubmitStatus) {
            this.taskSubmitStatus = taskSubmitStatus;
        }

        public int getTaskFinishStatus() {
            return taskFinishStatus;
        }

        public void setTaskFinishStatus(int taskFinishStatus) {
            this.taskFinishStatus = taskFinishStatus;
        }

        public String getTaskNo() {
            return taskNo;
        }

        public void setTaskNo(String taskNo) {
            this.taskNo = taskNo;
        }

        public String getCreatorType() {
            return creatorType;
        }

        public void setCreatorType(String creatorType) {
            this.creatorType = creatorType;
        }

        public String getOrganizationCodeChinese() {
            return organizationCodeChinese;
        }

        public void setOrganizationCodeChinese(String organizationCodeChinese) {
            this.organizationCodeChinese = organizationCodeChinese;
        }
    }
}
