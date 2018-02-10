package text.bwei.com.quarterhour.xiangqing.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.utils.RetroFactory;
import text.bwei.com.quarterhour.xiangqing.bean.DianzanBean;

/**
 * Created by dell on 2018/2/9.
 */

public class dianzanmodel implements Idianzanmodel {
    @Override
    public void Requetdianzan(String url, String uid, String wid, String token, final Onselectdianzan onselectdianzan) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("wid", wid);
        map.put("token", token);
//        https://www.zhaoapi.cn/quarter/praise?uid=11275&wid=250
        // &token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
        map.put("source", "android");
        map.put("appVersion", 101 + "");

        Observable<DianzanBean> getdianzandata = RetroFactory.getInstance().getdianzandata("quarter/praise", map);
        getdianzandata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DianzanBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DianzanBean dianzanBean) {
                        onselectdianzan.datadianzan(dianzanBean);
                    }
                });


    }
}
