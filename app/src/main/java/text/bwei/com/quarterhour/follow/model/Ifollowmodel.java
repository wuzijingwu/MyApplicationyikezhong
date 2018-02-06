package text.bwei.com.quarterhour.follow.model;

/**
 * Created by dell on 2018/2/5.
 */

public interface Ifollowmodel {
    //    https://www.zhaoapi.cn/quarter/getFollowUsers?uid=11275&
    // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
    void Requestfollow(String url, String uid, String token, Onselectfollow onselectfollow);
}
