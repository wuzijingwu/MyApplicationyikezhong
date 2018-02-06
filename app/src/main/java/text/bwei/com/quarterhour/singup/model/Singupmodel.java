package text.bwei.com.quarterhour.singup.model;

import android.util.Log;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.singup.bean.SingUpBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/4.
 */

public class Singupmodel implements ISingmodel {
    @Override
    public void Requestdata(String url, String mobile, String password, final OnsingupLinsenter onsingupLinsenter) {
        Log.i("==============.", "进来了");

        HashMap<String, String> map = new HashMap<>();
//        https://www.zhaoapi.cn/quarter/register?regType=0&mobile=15011460685&
//         password=123456&source=android&appVersion=101

        map.put("mobile", mobile);
        map.put("password", password);

        Observable<SingUpBean> getsingupdata = RetroFactory.getInstance().getsingupdata("quarter/register", map);


        getsingupdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SingUpBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i("==============.", "onCompleted");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("==============.", "e");
                    }

                    @Override
                    public void onNext(SingUpBean singUpBean) {
                        Log.i("==============.", "onNext");
                            onsingupLinsenter.OnSuccess(singUpBean);



                    }
                });
    }
}
