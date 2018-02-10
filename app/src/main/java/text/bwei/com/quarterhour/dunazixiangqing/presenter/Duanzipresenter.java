package text.bwei.com.quarterhour.dunazixiangqing.presenter;

import text.bwei.com.quarterhour.dunazixiangqing.bean.DuanziBean;
import text.bwei.com.quarterhour.dunazixiangqing.model.IDuanzimodel;
import text.bwei.com.quarterhour.dunazixiangqing.model.duanzimodel;
import text.bwei.com.quarterhour.dunazixiangqing.model.onselectduanzi;
import text.bwei.com.quarterhour.dunazixiangqing.view.IDuanziview;

/**
 * Created by dell on 2018/2/7.
 */

public class Duanzipresenter {
    IDuanziview iDuanziview;
    IDuanzimodel iDuanzimodel;

    public Duanzipresenter(IDuanziview iDuanziview) {
        this.iDuanziview = iDuanziview;
        iDuanzimodel = new duanzimodel();
    }

    public void getduanzi(String url, String jid) {
        iDuanzimodel.Requestduanzi(url, jid, new onselectduanzi() {
            @Override
            public void dataDuanzi(DuanziBean.DataBean list) {
                iDuanziview.showduanzi(list);
            }
        });


    }


}
