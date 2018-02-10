package text.bwei.com.quarterhour.dunazixiangqing.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.dunazixiangqing.bean.DuanziBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/7.
 */

public class duanzimodel implements IDuanzimodel {
    //    https://www.zhaoapi.cn/quarter/getJokeDetail?jid=1457&source=android&appVersion=101

    @Override
    public void Requestduanzi(String url, String jid, final onselectduanzi onselectduanzi) {
        HashMap<String, String> map = new HashMap<>();
        map.put("jid", jid);
        map.put("source", "android");
        map.put("appVersion", 101 + "");
        Observable<DuanziBean> duanziata = RetroFactory.getInstance().getDuanziata("quarter/getJokeDetail", map);
        duanziata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DuanziBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DuanziBean duanziBean) {
                        DuanziBean.DataBean data = duanziBean.getData();
                        onselectduanzi.dataDuanzi(data);

                    }
                });

    }
}
