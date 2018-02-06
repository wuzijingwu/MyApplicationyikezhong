package text.bwei.com.quarterhour.sousuo.presenter;

import java.util.List;

import text.bwei.com.quarterhour.sousuo.bean.SeekBean;
import text.bwei.com.quarterhour.sousuo.model.Iseekmodel;
import text.bwei.com.quarterhour.sousuo.model.OnselectSeek;
import text.bwei.com.quarterhour.sousuo.model.Seekmodel;
import text.bwei.com.quarterhour.sousuo.view.ISeekview;

/**
 * Created by dell on 2018/2/6.
 */

public class Seekpresenter {

    ISeekview iSeekview;
    Iseekmodel iseekmodel;

    public Seekpresenter(ISeekview iSeekview) {
        this.iSeekview = iSeekview;
        iseekmodel = new Seekmodel();
    }

    public void getSeek(String url, String keywords, String page) {
        iseekmodel.RequestSeek(url, keywords, page, new OnselectSeek() {
            @Override
            public void dataSeek(List<SeekBean.DataBean> list) {
                iSeekview.showSeek(list);
            }

            @Override
            public void dataError(String s) {

            }
        });


    }

}
