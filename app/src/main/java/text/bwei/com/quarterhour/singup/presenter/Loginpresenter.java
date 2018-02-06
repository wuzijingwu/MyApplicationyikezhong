package text.bwei.com.quarterhour.singup.presenter;

import text.bwei.com.quarterhour.singup.bean.LoginBean;
import text.bwei.com.quarterhour.singup.model.ILoginUpmodel;
import text.bwei.com.quarterhour.singup.model.Loginmodel;
import text.bwei.com.quarterhour.singup.model.OnselectloginLinstener;
import text.bwei.com.quarterhour.singup.view.ILonginview;

/**
 * Created by dell on 2018/2/4.
 */

public class Loginpresenter {

    ILonginview iLonginview;
    ILoginUpmodel iLoginUpmodel;

    public Loginpresenter(ILonginview iLonginview) {
        this.iLonginview = iLonginview;
        iLoginUpmodel = new Loginmodel();
    }

    public void getLogin(String url, String mobile, String password) {
        iLoginUpmodel.RequestLogin(url, mobile, password, new OnselectloginLinstener() {
            @Override
            public void dataLogin(LoginBean.DataBean list) {
                iLonginview.showLoginsuccess(list);
            }

            @Override
            public void dataError(String lists) {
                iLonginview.showLoginError();
            }
        });

    }

}
