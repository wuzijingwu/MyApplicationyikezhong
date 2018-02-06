package text.bwei.com.quarterhour.follow.model;

import java.util.List;

import text.bwei.com.quarterhour.follow.bean.FollowBean;

/**
 * Created by dell on 2018/2/5.
 */

public interface Onselectfollow {
    void datafollow(List<FollowBean.DataBean> data);

    void dataErrorfollow(String s);


}
