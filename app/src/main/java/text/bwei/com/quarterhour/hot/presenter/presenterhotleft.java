package text.bwei.com.quarterhour.hot.presenter;

import java.util.List;

import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
import text.bwei.com.quarterhour.hot.model.Ihotmodel;
import text.bwei.com.quarterhour.hot.model.Onselecthotleft;
import text.bwei.com.quarterhour.hot.model.modelhot;
import text.bwei.com.quarterhour.hot.view.Ihotview;

//import text.bwei.com.uuest.hot.bean.HotLeftBean;
//import text.bwei.com.uuest.hot.model.Ihotmodel;
//import text.bwei.com.uuest.hot.model.Onselecthotleft;
//import text.bwei.com.uuest.hot.model.modelhot;
//import text.bwei.com.uuest.hot.view.Ihotview;

/**
 * Created by dell on 2018/1/24.
 */

public class presenterhotleft {

    Ihotview ihotview;
    Ihotmodel ihotmodel;

    public presenterhotleft(Ihotview ihotview) {
        this.ihotview = ihotview;
        ihotmodel=new modelhot();
    }

    public void gethotleft(String url, int type, int page){
        ihotmodel.RequestHotLeft(url, type, page, new Onselecthotleft() {
            @Override
            public void dataSuccesshotleft(List<HotLeftBean.DataBean> list) {
                ihotview.showHotLeftview(list);
            }

            @Override
            public void dataErrorhotleft(String s) {

            }
        });


    }

}
