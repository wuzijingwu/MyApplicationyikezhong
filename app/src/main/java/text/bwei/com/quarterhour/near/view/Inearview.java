package text.bwei.com.quarterhour.near.view;

import java.util.List;

import text.bwei.com.quarterhour.near.bean.NearBean;

/**
 * Created by dell on 2018/1/30.
 */

public interface Inearview {
    void shownearSuccess(List<NearBean.DataBean> data);

    void showError();

}
