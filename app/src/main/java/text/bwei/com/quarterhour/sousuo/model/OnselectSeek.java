package text.bwei.com.quarterhour.sousuo.model;

import java.util.List;

import text.bwei.com.quarterhour.sousuo.bean.SeekBean;

/**
 * Created by dell on 2018/2/6.
 */

public interface OnselectSeek {
    void dataSeek(List<SeekBean.DataBean> list);

    void dataError(String s);
}
