package text.bwei.com.quarterhour.singup.model;

import text.bwei.com.quarterhour.singup.bean.SingUpBean;

/**
 * Created by dell on 2018/2/4.
 */

public interface OnsingupLinsenter {
    void OnSuccess(SingUpBean list);

    void OnError(String e);

}
