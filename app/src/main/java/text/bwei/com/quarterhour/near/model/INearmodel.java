package text.bwei.com.quarterhour.near.model;

/**
 * Created by dell on 2018/1/30.
 */

public interface INearmodel {
//    https://www.zhaoapi.cn/quarter/getNearVideos?page=2&
    // latitude=120&longitude=100&token=1&source=android&appVersion=101
    void RequestnearSuccess(String url, String page, String latitude, String longitude,String token, Onselectnear onselectnear);
}
