package text.bwei.com.quarterhour.sousuo.bean;

import java.util.List;

/**
 * Created by dell on 2018/2/6.
 */

public class HuanyipiBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"8c8f28d2a7d2f6f4","appsecret":"D1E35F2EBC86B5902A4DDA9F8D164B58","createtime":"2017-11-08T14:41:46","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15600107203","money":null,"nickname":null,"password":"36FEA9EDD86A667E4F3B327497470799","praiseNum":null,"token":"E6E8BCCE313BCE2317EBAD018E23EC31","uid":1797,"userId":null,"username":"15600107203"},{"age":null,"appkey":"99eee9cf9ec672e3","appsecret":"D3D4C1CA893DBB5FFA4A253DC5DF3B12","createtime":"2017-11-08T09:23:32","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18815515255","money":null,"nickname":null,"password":"96D4B05BC40E9CA4386CFE31668FB848","praiseNum":null,"token":null,"uid":1798,"userId":null,"username":"18815515255"},{"age":null,"appkey":"904bd4867929dffd","appsecret":"5C21FD00789031EDABA5EF0DDF509987","createtime":"2017-11-08T09:25:06","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13206780061","money":null,"nickname":null,"password":"96D4B05BC40E9CA4386CFE31668FB848","praiseNum":null,"token":"B3AA17961CD6ED8783898BC4BA02A519","uid":1799,"userId":null,"username":"13206780061"},{"age":null,"appkey":"3a81f499230c4126","appsecret":"D125FA96837EED991551E7B473EE44A5","createtime":"2017-11-08T09:24:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15600107204","money":null,"nickname":null,"password":"36FEA9EDD86A667E4F3B327497470799","praiseNum":null,"token":null,"uid":1800,"userId":null,"username":"15600107204"},{"age":null,"appkey":"ab219ea06e2fd1a2","appsecret":"04CFD68ED02412144DE6622891A86998","createtime":"2017-11-08T09:25:07","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15645659487","money":null,"nickname":null,"password":"39879F98AB6928D1D7146B332E8B3496","praiseNum":null,"token":null,"uid":1801,"userId":null,"username":"15645659487"},{"age":null,"appkey":"0e77741d191c0d2b","appsecret":"15CFF3AD0304CF70BC88309F293B161E","createtime":"2017-11-08T09:25:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18633357901","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":1802,"userId":null,"username":"18633357901"},{"age":null,"appkey":"d8113d0b5a417820","appsecret":"A663ACDF26D8D64B5807D5EE5F43BFED","createtime":"2017-11-08T09:42:41","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13775854296","money":null,"nickname":null,"password":"7F14BAAF818358E25E2D9C5259AA47DD","praiseNum":null,"token":"6B49FA9EF1B13D50FCF5B07E1126CEAA","uid":1803,"userId":null,"username":"13775854296"},{"age":null,"appkey":"33654983612fb05e","appsecret":"33413508FA3283E2E63BEC7D155231ED","createtime":"2017-11-08T09:29:24","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17600884995","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":1804,"userId":null,"username":"17600884995"},{"age":null,"appkey":"3a3e4de5c490d304","appsecret":"CE27C1F5FB676AF409668D741ACCCB34","createtime":"2017-11-08T09:31:18","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15256189817","money":null,"nickname":null,"password":"4664F6D879D9BC186F9C099671DC8747D4C5F972B7E266AB32CAFAB3BF154CF2","praiseNum":null,"token":null,"uid":1805,"userId":null,"username":"15256189817"},{"age":null,"appkey":"e67db4b362ad2381","appsecret":"498C3FC2DF9E0ABF264D4DDAA45CC075","createtime":"2017-11-08T09:33:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17601600899","money":null,"nickname":null,"password":"7F14BAAF818358E25E2D9C5259AA47DD","praiseNum":null,"token":"6EB948E44194FFC74A86D9DD1012EF28","uid":1806,"userId":null,"username":"17601600899"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 8c8f28d2a7d2f6f4
         * appsecret : D1E35F2EBC86B5902A4DDA9F8D164B58
         * createtime : 2017-11-08T14:41:46
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 15600107203
         * money : null
         * nickname : null
         * password : 36FEA9EDD86A667E4F3B327497470799
         * praiseNum : null
         * token : E6E8BCCE313BCE2317EBAD018E23EC31
         * uid : 1797
         * userId : null
         * username : 15600107203
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
