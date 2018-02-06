package text.bwei.com.quarterhour.hot.presenter;

import java.util.List;

import text.bwei.com.quarterhour.hot.bean.HotBean;
import text.bwei.com.quarterhour.hot.model.Ihotmodel;
import text.bwei.com.quarterhour.hot.model.Onselecthot;
import text.bwei.com.quarterhour.hot.model.modelhot;
import text.bwei.com.quarterhour.hot.view.Ihotview;

//import text.bwei.com.uuest.hot.bean.HotBean;
//import text.bwei.com.uuest.hot.model.Ihotmodel;
//import text.bwei.com.uuest.hot.model.Onselecthot;
//import text.bwei.com.uuest.hot.model.modelhot;
//import text.bwei.com.uuest.hot.view.Ihotview;

/**
 * Created by dell on 2018/1/24.
 */

public class presenterhot {
    Ihotmodel ihotmodel;
    Ihotview ihotview;

    public presenterhot(Ihotview ihotview) {
        this.ihotview = ihotview;
        ihotmodel = new modelhot();
    }



    public void destorys() {
        ihotview = null;

    }

    public void getHot(String url) {
        ihotmodel.RequestHot(url, new Onselecthot() {
            @Override
            public void dataSuccesshot(List<HotBean.DataBean> list) {
                ihotview.showHotview(list);
            }

            @Override
            public void dataErrorhot(String s) {

            }
        });


    }


}
