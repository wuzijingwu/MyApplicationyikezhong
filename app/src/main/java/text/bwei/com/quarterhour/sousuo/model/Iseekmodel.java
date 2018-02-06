package text.bwei.com.quarterhour.sousuo.model;

/**
 * Created by dell on 2018/2/6.
 */

public interface Iseekmodel {
//    https://www.zhaoapi.cn/quarter/searchFriends?keywords=%E5%B0%8F%E5%93%A5%E5%93%A5
    // &page=1&source=android&appVersion=101
    void RequestSeek(String url,String keywords,String page,OnselectSeek onselectSeek);

}
