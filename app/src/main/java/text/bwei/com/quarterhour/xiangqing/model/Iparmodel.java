package text.bwei.com.quarterhour.xiangqing.model;

/**
 * Created by dell on 2018/2/6.
 */

public interface Iparmodel {
//    https://www.zhaoapi.cn/quarter/follow?uid=11275&followId=200&
    // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
    void RequestPar(String url, String  uid,String followId,String token,Onselectpar onselectpar);

}
