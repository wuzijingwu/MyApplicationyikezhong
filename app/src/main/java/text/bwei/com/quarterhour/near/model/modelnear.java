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
    public void RequestnearSuccess(String url, String page, String latitude, String longitude,String token, final Onselectnear onselectnear) {
//        page=2&latitude=39.92 &longitude=116.46&token=1&source=android&appVersion=101
        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);

        map.put("page", page + "");
        map.put("latitude", latitude);
        map.put("longitude", longitude);
        map.put("source", "android");
        map.put("appVersion", "101");


//        https://www.zhaoapi.cn/quarter/getNearVideos?page=1&latitude=1&longitude=1&
        // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
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
                        List<NearBean.DataBean> data = nearBean.getData();

                        onselectnear.datanearSuccess(data);


                    }
                });

    }
}
