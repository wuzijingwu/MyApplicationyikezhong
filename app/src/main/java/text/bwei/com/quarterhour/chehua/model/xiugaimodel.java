package text.bwei.com.quarterhour.chehua.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.chehua.bean.XiugaiBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/7.
 */

public class xiugaimodel implements Ixiugaimodel {
    @Override
    public void RequestSuccess(String url, String uid, String nickname, String token, final Onselectxiugai onselectxiugai) {
        HashMap<String, String> map = new HashMap<>();
//        https://www.zhaoapi.cn/user/updateNickName?uid=11275&nickname=%E5%90%B4%E5%AD%90%E6%95%AC
        // &token=22D1BCB1DB0B5005D059F66F4FDD2238
        map.put("uid", uid);
        map.put("nickname", nickname);
        map.put("token", token);

        Observable<XiugaiBean> getxiugaiata = RetroFactory.getInstance().getxiugaiata("user/updateNickName", map);
        getxiugaiata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<XiugaiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(XiugaiBean xiugaiBean) {
                        onselectxiugai.dataxiugai(xiugaiBean);
                    }
                });

    }
}
