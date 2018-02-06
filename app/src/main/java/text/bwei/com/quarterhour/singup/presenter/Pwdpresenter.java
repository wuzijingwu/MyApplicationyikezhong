package text.bwei.com.quarterhour.singup.presenter;

import text.bwei.com.quarterhour.singup.bean.PwdBean;
import text.bwei.com.quarterhour.singup.model.IPwdmodel;
import text.bwei.com.quarterhour.singup.model.OnselectPwd;
import text.bwei.com.quarterhour.singup.model.Pwdmodel;
import text.bwei.com.quarterhour.singup.view.IPwdview;

/**
 * Created by dell on 2018/2/5.
 */

public class Pwdpresenter {
    IPwdview iPwdview;
    IPwdmodel iPwdmodel;

    public Pwdpresenter(IPwdview iPwdview) {
        this.iPwdview = iPwdview;
        iPwdmodel = new Pwdmodel();
    }

    public void getpwd(String url, String uid, String oldPassword, String newPassword) {
        iPwdmodel.Requestpwd(url, uid, oldPassword, newPassword, new OnselectPwd() {
            @Override
            public void datapwd(PwdBean list) {
                iPwdview.showPwd(list);
            }
        });


    }

}
