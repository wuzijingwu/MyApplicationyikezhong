package text.bwei.com.quarterhour.hots.presenter;

import java.util.List;

import text.bwei.com.quarterhour.hots.bean.HotsBeans;
import text.bwei.com.quarterhour.hots.model.Ihotsmodel;
import text.bwei.com.quarterhour.hots.model.Onselecthots;
import text.bwei.com.quarterhour.hots.model.modelhots;
import text.bwei.com.quarterhour.hots.view.Ihotsview;

//import text.bwei.com.uuest.hots.bean.HotsBeans;
//import text.bwei.com.uuest.hots.model.Ihotsmodel;
//import text.bwei.com.uuest.hots.model.Onselecthots;
//import text.bwei.com.uuest.hots.model.modelhots;
//import text.bwei.com.uuest.hots.view.Ihotsview;

/**
 * Created by dell on 2018/1/26.
 */

public class presenterhots {
    Ihotsview ihotsview;
    Ihotsmodel ihotsmodel;

    public presenterhots(Ihotsview ihotsview) {
        this.ihotsview = ihotsview;
        ihotsmodel = new modelhots();
    }

    public void gethotsviews(String url, int page) {
        ihotsmodel.Requesthots(url, page, new Onselecthots() {
            @Override
            public void datahotsSuccess(List<HotsBeans.DataBean> list) {
                ihotsview.showhotsSuccess(list);
            }
        });

    }


}
