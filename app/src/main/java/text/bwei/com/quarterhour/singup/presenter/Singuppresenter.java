package text.bwei.com.quarterhour.singup.presenter;

import text.bwei.com.quarterhour.singup.bean.SingUpBean;
import text.bwei.com.quarterhour.singup.model.ISingmodel;
import text.bwei.com.quarterhour.singup.model.OnsingupLinsenter;
import text.bwei.com.quarterhour.singup.model.Singupmodel;
import text.bwei.com.quarterhour.singup.view.ISingUpview;

/**
 * Created by dell on 2018/2/4.
 */

public class Singuppresenter {

    ISingUpview iSingUpview;
    ISingmodel iSingmodel;

    public Singuppresenter(ISingUpview iSingUpview) {
        this.iSingUpview = iSingUpview;
        iSingmodel = new Singupmodel();
    }

    public void onSingUp(String url, String mobile, String password) {
        iSingmodel.Requestdata(url, mobile, password, new OnsingupLinsenter() {
            @Override
            public void OnSuccess(SingUpBean list) {
                iSingUpview.ShowSign(list);
            }

            @Override
            public void OnError(String e) {

            }
        });

    }


}
