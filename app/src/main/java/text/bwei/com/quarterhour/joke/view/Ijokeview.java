package text.bwei.com.quarterhour.joke.view;

import java.util.List;

import text.bwei.com.quarterhour.joke.bean.JokeBean;

//import text.bwei.com.uuest.joke.bean.JokeBean;

/**
 * Created by dell on 2018/1/26.
 */

public interface Ijokeview {
    void showjokeSuccess(List<JokeBean.DataBean> list);

}
