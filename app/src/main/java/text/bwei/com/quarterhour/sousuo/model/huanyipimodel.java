package text.bwei.com.quarterhour.sousuo.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.sousuo.bean.HuanyipiBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/6.
 */

public class huanyipimodel implements Ihuanyipimodel {
    @Override
    public void Requesthunayipi(String url, final Onselecthuanyipi onselecthuanyipi) {

        HashMap<String, String> map = new HashMap<>();
//        source=android&appVersion=101
        map.put("source", "android");
        map.put("appVersion", 101 + "");

        Observable<HuanyipiBean> gethuanyipiata = RetroFactory.getInstance().gethuanyipiata("quarter/randomFriends", map);
        gethuanyipiata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HuanyipiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HuanyipiBean huanyipiBean) {
                        List<HuanyipiBean.DataBean> data = huanyipiBean.getData();
                        onselecthuanyipi.datahuanyipi(data);

                    }
                });


    }
}
