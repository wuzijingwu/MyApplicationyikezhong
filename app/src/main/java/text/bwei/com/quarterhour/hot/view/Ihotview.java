package text.bwei.com.quarterhour.hot.view;

import java.util.List;

import text.bwei.com.quarterhour.hot.bean.HotBean;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;

//import text.bwei.com.uuest.hot.bean.HotBean;
//import text.bwei.com.uuest.hot.bean.HotLeftBean;

/**
 * Created by dell on 2018/1/24.
 */

public interface Ihotview {
    void showHotview(List<HotBean.DataBean> list);

    void showHotLeftview(List<HotLeftBean.DataBean> list);


}
