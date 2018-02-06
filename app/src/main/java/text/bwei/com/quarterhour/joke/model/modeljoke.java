package text.bwei.com.quarterhour.joke.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.joke.bean.JokeBean;
import text.bwei.com.quarterhour.utils.RetroFactory;
//import text.bwei.com.uuest.joke.bean.JokeBean;
//import text.bwei.com.uuest.utils.RetroFactory;

/**
 * Created by dell on 2018/1/26.
 */

public class modeljoke implements Ijokemodel {
    @Override
    public void Requestjoke(String url, int page, final Onselectjoke onselectjoke) {
//        https://www.zhaoapi.cn/quarter/getJokes?page=1&source=android&appVersion=101
        HashMap<String, String> map = new HashMap<>();
        map.put("page",page+"");
//        source=android&appVersion=101
        map.put("source","android");
        map.put("appVersion",101+"");

        Observable<JokeBean> getjokedata = RetroFactory.getInstance().getjokedata("quarter/getJokes", map);
        getjokedata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JokeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JokeBean jokeBean) {
                        List<JokeBean.DataBean> data = jokeBean.getData();
                        onselectjoke.datajokeSuccess(data);

                    }
                });


    }
}
