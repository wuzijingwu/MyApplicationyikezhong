package text.bwei.com.quarterhour.singup.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.singup.bean.PwdBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/5.
 */

public class Pwdmodel implements IPwdmodel {
    @Override
    public void Requestpwd(String url, String uid, String oldPassword, String newPassword, final OnselectPwd onselectPwd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("oldPassword", oldPassword);
        map.put("newPassword", newPassword);
        Observable<PwdBean> getpwddata = RetroFactory.getInstance().getpwddata("quarter/resetPass", map);
        getpwddata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PwdBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PwdBean pwdBean) {
                        onselectPwd.datapwd(pwdBean);
                    }
                });


    }
}
