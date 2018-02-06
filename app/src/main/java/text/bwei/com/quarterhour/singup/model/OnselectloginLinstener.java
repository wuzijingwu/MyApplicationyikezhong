package text.bwei.com.quarterhour.singup.model;

import text.bwei.com.quarterhour.singup.bean.LoginBean;

/**
 * Created by dell on 2018/2/4.
 */

public interface OnselectloginLinstener {

    void dataLogin(LoginBean.DataBean list);

    void dataError(String lists);



}
