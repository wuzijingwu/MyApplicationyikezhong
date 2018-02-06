package text.bwei.com.quarterhour.fabiao.model;

/**
 * Created by dell on 2018/2/6.
 */

public interface ICrosstalkmodel {
//    https://www.zhaoapi.cn/quarter/publishJoke?uid=11275&content=123456&
    // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
    void RequestCrossalk(String url,String uid,String content,String token,OnselectCrosstalk onselectCrosstalk);

}
