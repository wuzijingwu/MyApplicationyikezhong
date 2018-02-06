package text.bwei.com.quarterhour.near.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.near.bean.NearBean;
import text.bwei.com.quarterhour.utils.RetroFactory;
//import text.bwei.com.uuest.near.bean.NearBean;
//import text.bwei.com.uuest.utils.RetroFactory;

/**
 * Created by dell on 2018/1/30.
 */

public class modelnear implements INearmodel {
    @Override
    public void RequestnearSuccess(String url, int page, String latitude, String longitude, final Onselectnear onselectnear) {
//        page=2&latitude=39.92 &longitude=116.46&token=1&source=android&appVersion=101
        HashMap<String, String> map = new HashMap<>();
        map.put("token", "1");
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("page", page + "");
        map.put("latitude", latitude);
        map.put("longitude", longitude);


        Observable<NearBean> getneardata = RetroFactory.getInstance().getneardata("quarter/getNearVideos", map);
        getneardata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NearBean>() {
                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NearBean nearBean) {
                        List<?> data = nearBean.getData();
                        onselectnear.datanearSuccess(data);


                    }
                });

    }
}
