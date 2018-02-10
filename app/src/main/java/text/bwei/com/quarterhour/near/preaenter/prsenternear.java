package text.bwei.com.quarterhour.near.preaenter;

import java.util.List;

import text.bwei.com.quarterhour.near.bean.NearBean;
import text.bwei.com.quarterhour.near.model.INearmodel;
import text.bwei.com.quarterhour.near.model.Onselectnear;
import text.bwei.com.quarterhour.near.model.modelnear;
import text.bwei.com.quarterhour.near.view.Inearview;

//import text.bwei.com.uuest.near.model.INearmodel;
//import text.bwei.com.uuest.near.model.Onselectnear;
//import text.bwei.com.uuest.near.model.modelnear;
//import text.bwei.com.uuest.near.view.Inearview;

/**
 * Created by dell on 2018/1/30.
 */

public class prsenternear {

    Inearview inearview;
    INearmodel iNearmodel;

    public prsenternear(Inearview inearview) {
        this.inearview = inearview;
        iNearmodel = new modelnear();
    }
//    https://www.zhaoapi.cn/quarter/getNearVideos?page=2&latitude=120
    // &longitude=100&token=1&source=android&appVersion=101
    public void getnear(String url, String page, String latitude,  String longitude,String token) {
        iNearmodel.RequestnearSuccess(url, page, latitude, longitude, token, new Onselectnear() {
            @Override
            public void datanearSuccess(List<NearBean.DataBean> data) {
                inearview.shownearSuccess(data);
            }
        });


    }


}
