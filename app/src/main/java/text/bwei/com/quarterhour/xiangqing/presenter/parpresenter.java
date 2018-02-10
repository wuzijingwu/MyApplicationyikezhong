package text.bwei.com.quarterhour.xiangqing.presenter;

import text.bwei.com.quarterhour.xiangqing.bean.ParBean;
import text.bwei.com.quarterhour.xiangqing.model.Iparmodel;
import text.bwei.com.quarterhour.xiangqing.model.Onselectpar;
import text.bwei.com.quarterhour.xiangqing.model.parmodel;
import text.bwei.com.quarterhour.xiangqing.view.Iparview;

/**
 * Created by dell on 2018/2/6.
 */

public class parpresenter {

    Iparview iparview;
    Iparmodel iparmodel;

    public parpresenter(Iparview iparview) {
        this.iparview = iparview;
        iparmodel = new parmodel();
    }

    public void getpar(String url, String uid, String followId, String token) {
        iparmodel.RequestPar(url, uid, followId, token, new Onselectpar() {
            @Override
            public void datapar(ParBean list) {
                iparview.showPar(list);
            }
        });


    }

}
