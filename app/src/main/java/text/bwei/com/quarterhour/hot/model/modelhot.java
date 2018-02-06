package text.bwei.com.quarterhour.hot.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.hot.bean.HotBean;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
import text.bwei.com.quarterhour.utils.RetroFactory;
//import text.bwei.com.uuest.hot.bean.HotBean;
//import text.bwei.com.uuest.hot.bean.HotLeftBean;
//import text.bwei.com.uuest.utils.RetroFactory;

/**
 * Created by dell on 2018/1/24.
 */

public class modelhot implements Ihotmodel {
    @Override
    public void RequestHot(String url, final Onselecthot onselecthot) {

        Observable<HotBean> gethotdata = RetroFactory.getInstance().gethotdata();
        gethotdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onselecthot.dataErrorhot(e.toString());

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        List<HotBean.DataBean> data = hotBean.getData();
                        onselecthot.dataSuccesshot(data);


                    }
                });


    }

    @Override
    public void RequestHotLeft(String url, int type, int page, final Onselecthotleft onselecthotleft) {

        HashMap<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("type", type + "");
        map.put("page", page + "");
        Observable<HotLeftBean> gethotleftdata = RetroFactory.getInstance().gethotleftdata("quarter/getVideos", map);
        gethotleftdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotLeftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HotLeftBean hotLeftBean) {
                        List<HotLeftBean.DataBean> data = hotLeftBean.getData();
                        onselecthotleft.dataSuccesshotleft(data);
                    }
                });


    }
}
