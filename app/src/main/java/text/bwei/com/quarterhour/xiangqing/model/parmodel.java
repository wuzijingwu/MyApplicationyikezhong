package text.bwei.com.quarterhour.xiangqing.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.utils.RetroFactory;
import text.bwei.com.quarterhour.xiangqing.bean.ParBean;

/**
 * Created by dell on 2018/2/6.
 */

public class parmodel implements Iparmodel {
    @Override
    public void RequestPar(String url, String uid, String followId, String token, final Onselectpar onselectpar) {
//        https://www.zhaoapi.cn/quarter/follow?uid=11275&followId=200&
//        // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("followId", followId);
        map.put("token", token);
        map.put("source", "android");
        map.put("appVersion", 101 + "");
        Observable<ParBean> getparata = RetroFactory.getInstance().getparata("quarter/follow", map);
        getparata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ParBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ParBean parBean) {

                        onselectpar.datapar(parBean);

                    }
                });

    }
}
