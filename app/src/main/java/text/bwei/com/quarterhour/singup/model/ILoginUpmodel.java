package text.bwei.com.quarterhour.singup.model;

/**
 * Created by dell on 2018/2/4.
 */

public interface ILoginUpmodel {
//    https://www.zhaoapi.cn/user/login?mobile=15011460685&password=123456
    void RequestLogin(String url,String mobile,String password,OnselectloginLinstener onselectloginLinstener);

}
