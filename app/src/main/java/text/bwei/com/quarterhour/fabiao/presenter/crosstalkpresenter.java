package text.bwei.com.quarterhour.fabiao.presenter;

import text.bwei.com.quarterhour.fabiao.bean.CrosstalkBean;
import text.bwei.com.quarterhour.fabiao.model.Crosstalkmodel;
import text.bwei.com.quarterhour.fabiao.model.ICrosstalkmodel;
import text.bwei.com.quarterhour.fabiao.model.OnselectCrosstalk;
import text.bwei.com.quarterhour.fabiao.view.ICrosstalkview;

/**
 * Created by dell on 2018/2/6.
 */

public class crosstalkpresenter {
    ICrosstalkview iCrosstalkview;
    ICrosstalkmodel iCrosstalkmodel;

    public crosstalkpresenter(ICrosstalkview iCrosstalkview) {
        this.iCrosstalkview = iCrosstalkview;
        iCrosstalkmodel=new Crosstalkmodel();


    }

    public void getcrosstalk(String url, String uid, String content, String token) {
        iCrosstalkmodel.RequestCrossalk(url, uid, content, token, new OnselectCrosstalk() {
            @Override
            public void dataCrosstalk(CrosstalkBean list) {
                iCrosstalkview.showcrossUccess(list);
            }
        });

    }

}
