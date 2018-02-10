package text.bwei.com.quarterhour.chehua.presenter;

import text.bwei.com.quarterhour.chehua.bean.XiugaiBean;
import text.bwei.com.quarterhour.chehua.model.Ixiugaimodel;
import text.bwei.com.quarterhour.chehua.model.Onselectxiugai;
import text.bwei.com.quarterhour.chehua.model.xiugaimodel;
import text.bwei.com.quarterhour.chehua.view.Ixiugaiview;

/**
 * Created by dell on 2018/2/7.
 */

public class xiugaipresenter {
    Ixiugaiview ixiugaiview;
    Ixiugaimodel ixiugaimodel;

    public xiugaipresenter(Ixiugaiview ixiugaiview) {
        this.ixiugaiview = ixiugaiview;
        ixiugaimodel = new xiugaimodel();
    }

    public void getxiugai(String url, String uid, String nickname, String token) {
        ixiugaimodel.RequestSuccess(url, uid, nickname, token, new Onselectxiugai() {
            @Override
            public void dataxiugai(XiugaiBean list) {
                ixiugaiview.showxiugai(list);
            }
        });

    }

}
