package text.bwei.com.quarterhour.joke.presenter;

import java.util.List;

import text.bwei.com.quarterhour.joke.bean.JokeBean;
import text.bwei.com.quarterhour.joke.model.Ijokemodel;
import text.bwei.com.quarterhour.joke.model.Onselectjoke;
import text.bwei.com.quarterhour.joke.model.modeljoke;
import text.bwei.com.quarterhour.joke.view.Ijokeview;

//import text.bwei.com.uuest.joke.bean.JokeBean;
//import text.bwei.com.uuest.joke.model.Ijokemodel;
//import text.bwei.com.uuest.joke.model.Onselectjoke;
//import text.bwei.com.uuest.joke.model.modeljoke;
//import text.bwei.com.uuest.joke.view.Ijokeview;

/**
 * Created by dell on 2018/1/26.
 */

public class presenterjoke {
    Ijokeview ijokeview;
    Ijokemodel ijokemodel;

    public presenterjoke(Ijokeview ijokeview) {
        this.ijokeview = ijokeview;
        ijokemodel = new modeljoke();
    }

    public void destorysd() {
        ijokeview = null;

    }

    public void getjoke(String url, int page) {
        ijokemodel.Requestjoke(url, page, new Onselectjoke() {
            @Override
            public void datajokeSuccess(List<JokeBean.DataBean> list) {
                ijokeview.showjokeSuccess(list);
            }

            @Override
            public void datajokeError(String s) {

            }
        });


    }

}
