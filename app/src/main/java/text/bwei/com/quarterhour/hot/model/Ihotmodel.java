package text.bwei.com.quarterhour.hot.model;

/**
 * Created by dell on 2018/1/24.
 */

public interface Ihotmodel {
    void RequestHot(String url, Onselecthot onselecthot);

    void RequestHotLeft(String url, int type, int page, Onselecthotleft onselecthotleft);


}
