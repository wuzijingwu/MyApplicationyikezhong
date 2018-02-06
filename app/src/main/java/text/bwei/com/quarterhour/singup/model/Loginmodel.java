package text.bwei.com.quarterhour.singup.model;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.singup.bean.LoginBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/4.
 */

public class Loginmodel implements ILoginUpmodel {
    @Override
    public void RequestLogin(String url, String mobile, String password, final OnselectloginLinstener onselectloginLinstener) {

        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", password);

        Observable<LoginBean> logindata = RetroFactory.getInstance().getLogindata("user/login", map);
        logindata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (loginBean.getMsg().equals("登录成功")) {
                            LoginBean.DataBean data = loginBean.getData();
                            onselectloginLinstener.dataLogin(data);
                        } else {
                            onselectloginLinstener.dataError(loginBean.getMsg());
                        }

                    }
                });

    }
}
