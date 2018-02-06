package text.bwei.com.quarterhour.near.model;

/**
 * Created by dell on 2018/1/30.
 */

public interface INearmodel {
    void RequestnearSuccess(String url, int page, String latitude, String longitude, Onselectnear onselectnear);
}
