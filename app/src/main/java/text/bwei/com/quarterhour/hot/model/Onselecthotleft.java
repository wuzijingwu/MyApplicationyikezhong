package text.bwei.com.quarterhour.hot.model;

import java.util.List;

import text.bwei.com.quarterhour.hot.bean.HotLeftBean;

//import text.bwei.com.uuest.hot.bean.HotLeftBean;

/**
 * Created by dell on 2018/1/24.
 */

public interface Onselecthotleft {
    void dataSuccesshotleft(List<HotLeftBean.DataBean> list);
    void dataErrorhotleft(String s);

}
