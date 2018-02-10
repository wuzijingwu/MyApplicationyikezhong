package text.bwei.com.quarterhour.hots.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.hots.bean.HotsBeans;
import text.bwei.com.quarterhour.utils.RetroFactory;
//import text.bwei.com.uuest.hots.bean.HotsBeans;
//import text.bwei.com.uuest.utils.RetroFactory;

/**
 * Created by dell on 2018/1/26.
 */

public class modelhots implements Ihotsmodel {
    @Override
    public void Requesthots(String url, int page,String token, final Onselecthots onselecthots) {
//        quarter/getHotVideos?page=1&source=android&appVersion=101&token=1
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("source", "android");
        map.put("appVersion", 101 + "");
        map.put("token", token);

        Observable<HotsBeans> hotsdata = RetroFactory.getInstance().getHotsdata("quarter/getHotVideos", map);
        hotsdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotsBeans>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HotsBeans hotsBeans) {
                        List<HotsBeans.DataBean> data = hotsBeans.getData();
                        onselecthots.datahotsSuccess(data);


                    }
                });


    }
}
