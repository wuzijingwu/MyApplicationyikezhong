package text.bwei.com.quarterhour.singup.model;

/**
 * Created by dell on 2018/2/5.
 */

public interface IPwdmodel {
//    https://www.zhaoapi.cn/quarter/resetPass?uid=11275&oldPassword=123456
//    //https://www.zhaoapi.cn/quarter/resetPass?uid=11275&oldPassword=123456&newPassword=1234567

    void Requestpwd(String url, String uid, String oldPassword, String newPassword, OnselectPwd onselectPwd);

}
