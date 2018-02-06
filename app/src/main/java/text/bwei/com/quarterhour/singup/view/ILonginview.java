package text.bwei.com.quarterhour.singup.view;

import text.bwei.com.quarterhour.singup.bean.LoginBean;

/**
 * Created by dell on 2018/2/4.
 */

public interface ILonginview {
    //    https://www.zhaoapi.cn/user/login?mobile=15011460685&password=123456
    void showLoginsuccess(LoginBean.DataBean list);

    void showLoginError();

}
