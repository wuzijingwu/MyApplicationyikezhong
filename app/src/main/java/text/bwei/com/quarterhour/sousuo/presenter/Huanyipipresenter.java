package text.bwei.com.quarterhour.sousuo.presenter;

import java.util.List;

import text.bwei.com.quarterhour.sousuo.bean.HuanyipiBean;
import text.bwei.com.quarterhour.sousuo.model.Ihuanyipimodel;
import text.bwei.com.quarterhour.sousuo.model.Onselecthuanyipi;
import text.bwei.com.quarterhour.sousuo.model.huanyipimodel;
import text.bwei.com.quarterhour.sousuo.view.IInabatchview;

/**
 * Created by dell on 2018/2/6.
 */

public class Huanyipipresenter {
    IInabatchview iInabatchview;
    Ihuanyipimodel ihuanyipimodel;

    public Huanyipipresenter(IInabatchview iInabatchview) {
        this.iInabatchview = iInabatchview;
        ihuanyipimodel = new huanyipimodel();
    }

    public void gethuanyipi(String url) {
        ihuanyipimodel.Requesthunayipi(url, new Onselecthuanyipi() {
            @Override
            public void datahuanyipi(List<HuanyipiBean.DataBean> list) {
                iInabatchview.showhunayipi(list);
            }
        });


    }

}
