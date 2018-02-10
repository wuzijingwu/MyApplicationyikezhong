package text.bwei.com.quarterhour.xiangqing.presenter;

import text.bwei.com.quarterhour.xiangqing.bean.DianzanBean;
import text.bwei.com.quarterhour.xiangqing.model.Idianzanmodel;
import text.bwei.com.quarterhour.xiangqing.model.Onselectdianzan;
import text.bwei.com.quarterhour.xiangqing.model.dianzanmodel;
import text.bwei.com.quarterhour.xiangqing.view.Idianzanview;

/**
 * Created by dell on 2018/2/9.
 */

public class dianzanpresenter {
    Idianzanmodel idianzanmodel;
    Idianzanview idianzanview;

    public dianzanpresenter(Idianzanview idianzanview) {
        this.idianzanview = idianzanview;
        idianzanmodel=new dianzanmodel();
    }

    public void dianzan(String url, String uid, String wid, String token) {
        idianzanmodel.Requetdianzan(url, uid, wid, token, new Onselectdianzan() {
            @Override
            public void datadianzan(DianzanBean list) {
                idianzanview.showdianzan(list);
            }
        });


    }
}
