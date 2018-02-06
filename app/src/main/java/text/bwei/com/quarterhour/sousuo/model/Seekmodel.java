package text.bwei.com.quarterhour.sousuo.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.sousuo.bean.SeekBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/6.
 */

public class Seekmodel implements Iseekmodel {
    //    https://www.zhaoapi.cn/quarter/searchFriends?keywords=%E5%B0%8F%E5%93%A5%E5%93%A5
    // &page=1&source=android&appVersion=101
    @Override
    public void RequestSeek(String url, String keywords, String page, final OnselectSeek onselectSeek) {
        HashMap<String, String> map = new HashMap<>();
        map.put("keywords", keywords);
        map.put("page", page);
        map.put("source", "android");
        map.put("appVersion", 101 + "");
        Observable<SeekBean> getseekdata = RetroFactory.getInstance().getseekdata("quarter/searchFriends", map);
        getseekdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SeekBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SeekBean seekBean) {

                        List<SeekBean.DataBean> data = seekBean.getData();

                        onselectSeek.dataSeek(data);
                    }
                });


    }
}
