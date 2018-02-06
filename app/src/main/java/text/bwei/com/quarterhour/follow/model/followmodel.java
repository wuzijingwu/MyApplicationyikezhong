package text.bwei.com.quarterhour.follow.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.follow.bean.FollowBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/5.
 */

public class followmodel implements Ifollowmodel {
    @Override
    public void Requestfollow(String url, String uid, String token, final Onselectfollow onselectfollow) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);

        map.put("token", token);
//        https://www.zhaoapi.cn/quarter/follow?uid=11275&followId=1&
        // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
        map.put("source", "android");
        map.put("appVersion", 101 + "");

        Observable<FollowBean> getfollowdata = RetroFactory.getInstance().getfollowdata("quarter/getFollowUsers", map);
        getfollowdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FollowBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FollowBean followBean) {
                        List<FollowBean.DataBean> data = followBean.getData();
                        onselectfollow.datafollow(data);

                    }
                });

    }
}
