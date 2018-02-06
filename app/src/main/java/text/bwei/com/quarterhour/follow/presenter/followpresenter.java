package text.bwei.com.quarterhour.follow.presenter;


import java.util.List;

import text.bwei.com.quarterhour.follow.bean.FollowBean;
import text.bwei.com.quarterhour.follow.model.Ifollowmodel;
import text.bwei.com.quarterhour.follow.model.Onselectfollow;
import text.bwei.com.quarterhour.follow.model.followmodel;
import text.bwei.com.quarterhour.follow.view.Ifollowview;

/**
 * Created by dell on 2018/2/5.
 */

public class followpresenter {
    Ifollowview ifollowview;
    Ifollowmodel ifollowmodel;

    public followpresenter(Ifollowview ifollowview) {
        this.ifollowview = ifollowview;
        ifollowmodel = new followmodel();
    }

    public void getfollow(String url, String uid, String token) {
        ifollowmodel.Requestfollow(url, uid, token, new Onselectfollow() {
            @Override
            public void datafollow(List<FollowBean.DataBean> data) {
                ifollowview.showfollow(data);
            }

            @Override
            public void dataErrorfollow(String s) {

            }
        });
    }

}
