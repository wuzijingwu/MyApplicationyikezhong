package text.bwei.com.quarterhour.hot.model;

import java.util.List;

import text.bwei.com.quarterhour.hot.bean.HotBean;

//import text.bwei.com.uuest.hot.bean.HotBean;

/**
 * Created by dell on 2018/1/24.
 */

public interface Onselecthot {
    void dataSuccesshot(List<HotBean.DataBean> list);
    void dataErrorhot(String s);


}
