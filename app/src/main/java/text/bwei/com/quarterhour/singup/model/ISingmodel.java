package text.bwei.com.quarterhour.singup.model;

/**
 * Created by dell on 2018/2/4.
 */

public interface ISingmodel {
    //    https://www.zhaoapi.cn/quarter/register?regType=0&
    // mobile=15011460685&password=123456&source=android&appVersion=101
    void Requestdata(String url, String mobile, String password, OnsingupLinsenter onsingupLinsenter);
}
