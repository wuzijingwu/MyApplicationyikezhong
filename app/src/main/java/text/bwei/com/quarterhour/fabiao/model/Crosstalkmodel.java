package text.bwei.com.quarterhour.fabiao.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.fabiao.bean.CrosstalkBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/6.
 */

public class Crosstalkmodel implements ICrosstalkmodel {
    //    https://www.zhaoapi.cn/quarter/publishJoke?uid=11275&content=123456&
    // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
    @Override
    public void RequestCrossalk(String url, String uid, String content, String token, final OnselectCrosstalk onselectCrosstalk) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("content", content);
        map.put("token", token);
        map.put("source", "android");
        map.put("appVersion", 101 + "");

        Observable<CrosstalkBean> getcrosstalkdata = RetroFactory.getInstance().getcrosstalkdata("quarter/publishJoke", map);

        getcrosstalkdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CrosstalkBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CrosstalkBean crosstalkBean) {
                        onselectCrosstalk.dataCrosstalk(crosstalkBean);
                    }
                });


    }
}
