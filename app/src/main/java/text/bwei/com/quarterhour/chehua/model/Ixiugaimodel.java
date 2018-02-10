package text.bwei.com.quarterhour.chehua.model;

/**
 * Created by dell on 2018/2/7.
 */

public interface Ixiugaimodel {
    //    https://www.zhaoapi.cn/user/updateNickName?uid=11275&nickname=%E5%90%B4%E5%AD%90%E6%95%AC
    // &token=22D1BCB1DB0B5005D059F66F4FDD2238
    void RequestSuccess(String url, String uid, String nickname, String token, Onselectxiugai onselectxiugai);

}
