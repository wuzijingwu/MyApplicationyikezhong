package text.bwei.com.quarterhour.bendi.model;

import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.quarterhour.bendi.bean.NativeBean;
import text.bwei.com.quarterhour.utils.RetroFactory;

/**
 * Created by dell on 2018/2/8.
 */

public class nativemodel implements Inativemodel {
    @Override
    public void Requestnative(String url, String page, final Onselectnatives onselectnative) {


        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);


        Observable<NativeBean> getnativedata = RetroFactory.getInstance().getnativedata("v5/newlist", map);
        getnativedata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NativeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NativeBean nativeBean) {
                        List<NativeBean.GoodsListBean> goods_list = nativeBean.getGoods_list();
                        onselectnative.datanative(goods_list);

                    }
                });

    }
}
