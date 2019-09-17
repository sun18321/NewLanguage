package com.sun.newlanguage.bean;

import java.util.List;

public class JavaBean {

    /**
     * code : 1
     * msg : [{"id":"5d20a722c200571242cb8471","userId":"18555556688","name":"帕吉","gender":1,"date":"2010-01-01","type":0,"gameType":[{"type":1010,"price":5},{"type":1000,"price":5},{"type":1011,"price":10}],"price":0,"gold":98539,"gameZone":0,"sign":"一起大保健","url":"http://39.100.96.9:7070/peipeiImg/icon/576bb550618fd2ac9ba19de15451c6f5","inviteCode":"98PQ2YA","inviteFlag":1,"favor":2,"interest":"大保健","profession":"身体是革命的本钱，保持健康乐观。","applyName":"特朗普","applyIdentity":"340521199808091345","applyPhone":18555556688,"applyAccount":"啊啊啊","otherGame":"大保健","localX":31.241941,"localY":121.671253,"address":"上海","isShowLbs":1,"userName":"sun","userNameUpset":1,"evaluateNum":7,"evaluateSum":54,"evaluateTotal":378,"favorList":[],"favorListSize":0}]
     */

    private int code;
    private List<MsgBean> msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * id : 5d20a722c200571242cb8471
         * userId : 18555556688
         * name : 帕吉
         * gender : 1
         * date : 2010-01-01
         * type : 0
         * gameType : [{"type":1010,"price":5},{"type":1000,"price":5},{"type":1011,"price":10}]
         * price : 0
         * gold : 98539.0
         * gameZone : 0
         * sign : 一起大保健
         * url : http://39.100.96.9:7070/peipeiImg/icon/576bb550618fd2ac9ba19de15451c6f5
         * inviteCode : 98PQ2YA
         * inviteFlag : 1
         * favor : 2
         * interest : 大保健
         * profession : 身体是革命的本钱，保持健康乐观。
         * applyName : 特朗普
         * applyIdentity : 340521199808091345
         * applyPhone : 18555556688
         * applyAccount : 啊啊啊
         * otherGame : 大保健
         * localX : 31.241941
         * localY : 121.671253
         * address : 上海
         * isShowLbs : 1
         * userName : sun
         * userNameUpset : 1
         * evaluateNum : 7
         * evaluateSum : 54
         * evaluateTotal : 378
         * favorList : []
         * favorListSize : 0
         */

        private String id;
        private String userId;
        private String name;
        private int gender;
        private String date;
        private int type;
        private int price;
        private double gold;
        private int gameZone;
        private String sign;
        private String url;
        private String inviteCode;
        private int inviteFlag;
        private int favor;
        private String interest;
        private String profession;
        private String applyName;
        private String applyIdentity;
        private long applyPhone;
        private String applyAccount;
        private String otherGame;
        private double localX;
        private double localY;
        private String address;
        private int isShowLbs;
        private String userName;
        private int userNameUpset;
        private int evaluateNum;
        private int evaluateSum;
        private int evaluateTotal;
        private int favorListSize;
        private List<GameTypeBean> gameType;
        private List<?> favorList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public double getGold() {
            return gold;
        }

        public void setGold(double gold) {
            this.gold = gold;
        }

        public int getGameZone() {
            return gameZone;
        }

        public void setGameZone(int gameZone) {
            this.gameZone = gameZone;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public int getInviteFlag() {
            return inviteFlag;
        }

        public void setInviteFlag(int inviteFlag) {
            this.inviteFlag = inviteFlag;
        }

        public int getFavor() {
            return favor;
        }

        public void setFavor(int favor) {
            this.favor = favor;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getApplyName() {
            return applyName;
        }

        public void setApplyName(String applyName) {
            this.applyName = applyName;
        }

        public String getApplyIdentity() {
            return applyIdentity;
        }

        public void setApplyIdentity(String applyIdentity) {
            this.applyIdentity = applyIdentity;
        }

        public long getApplyPhone() {
            return applyPhone;
        }

        public void setApplyPhone(long applyPhone) {
            this.applyPhone = applyPhone;
        }

        public String getApplyAccount() {
            return applyAccount;
        }

        public void setApplyAccount(String applyAccount) {
            this.applyAccount = applyAccount;
        }

        public String getOtherGame() {
            return otherGame;
        }

        public void setOtherGame(String otherGame) {
            this.otherGame = otherGame;
        }

        public double getLocalX() {
            return localX;
        }

        public void setLocalX(double localX) {
            this.localX = localX;
        }

        public double getLocalY() {
            return localY;
        }

        public void setLocalY(double localY) {
            this.localY = localY;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIsShowLbs() {
            return isShowLbs;
        }

        public void setIsShowLbs(int isShowLbs) {
            this.isShowLbs = isShowLbs;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserNameUpset() {
            return userNameUpset;
        }

        public void setUserNameUpset(int userNameUpset) {
            this.userNameUpset = userNameUpset;
        }

        public int getEvaluateNum() {
            return evaluateNum;
        }

        public void setEvaluateNum(int evaluateNum) {
            this.evaluateNum = evaluateNum;
        }

        public int getEvaluateSum() {
            return evaluateSum;
        }

        public void setEvaluateSum(int evaluateSum) {
            this.evaluateSum = evaluateSum;
        }

        public int getEvaluateTotal() {
            return evaluateTotal;
        }

        public void setEvaluateTotal(int evaluateTotal) {
            this.evaluateTotal = evaluateTotal;
        }

        public int getFavorListSize() {
            return favorListSize;
        }

        public void setFavorListSize(int favorListSize) {
            this.favorListSize = favorListSize;
        }

        public List<GameTypeBean> getGameType() {
            return gameType;
        }

        public void setGameType(List<GameTypeBean> gameType) {
            this.gameType = gameType;
        }

        public List<?> getFavorList() {
            return favorList;
        }

        public void setFavorList(List<?> favorList) {
            this.favorList = favorList;
        }

        public static class GameTypeBean {
            /**
             * type : 1010
             * price : 5
             */

            private int type;
            private int price;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
