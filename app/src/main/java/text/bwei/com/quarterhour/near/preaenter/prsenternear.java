package text.bwei.com.quarterhour.near.preaenter;

import java.util.List;

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

    public void getnear(String url, int page, String latitude, String longitude) {
        iNearmodel.RequestnearSuccess(url, page, latitude, longitude, new Onselectnear() {
            @Override
            public void datanearSuccess(List<?> list) {
                inearview.shownearSuccess(list);
            }
        });


    }


}
