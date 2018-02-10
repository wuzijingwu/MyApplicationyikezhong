package text.bwei.com.quarterhour.bendi.presenter;

import java.util.List;

import text.bwei.com.quarterhour.bendi.bean.NativeBean;
import text.bwei.com.quarterhour.bendi.model.Inativemodel;
import text.bwei.com.quarterhour.bendi.model.Onselectnatives;
import text.bwei.com.quarterhour.bendi.model.nativemodel;
import text.bwei.com.quarterhour.bendi.view.Inativeview;

/**
 * Created by dell on 2018/2/8.
 */

public class nativeprsenter {
    Inativeview inativeview;
    Inativemodel inativemodel;

    public nativeprsenter(Inativeview inativeview) {
        this.inativeview = inativeview;
        inativemodel = new nativemodel();
    }

    public void getnative(String url,String page) {
        inativemodel.Requestnative(url,page, new Onselectnatives() {
            @Override
            public void datanative(List<NativeBean.GoodsListBean> list) {
                inativeview.showSuccess(list);
            }
        });

    }
}
