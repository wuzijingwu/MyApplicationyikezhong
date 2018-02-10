package text.bwei.com.quarterhour.chehua;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.chehua.bean.XiugaiBean;
import text.bwei.com.quarterhour.chehua.presenter.xiugaipresenter;
import text.bwei.com.quarterhour.chehua.view.Ixiugaiview;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/7.
 */

public class BianjiActivity extends Activity implements Ixiugaiview {
    @BindView(R.id.nichewng)
    EditText nichewng;
    @BindView(R.id.queding)
    Button queding;
    private text.bwei.com.quarterhour.chehua.presenter.xiugaipresenter xiugaipresenter;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bian);
        ButterKnife.bind(this);
        xiugaipresenter = new xiugaipresenter(this);


    }

    @OnClick({R.id.nichewng, R.id.queding})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.nichewng:
                break;
            case R.id.queding:
                name = nichewng.getText().toString().trim();

//                sp.edit().putString("name", list.getMobile())
//                        .putInt("uid", list.getUid())
//                        .putString("pwd", list.getPassword())
//                        .putString("token", list.getToken()).commit();

                SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
                int uid = user.getInt("uid", 1);
                String token = user.getString("token", "000");

                xiugaipresenter.getxiugai(Api.URL, uid + "", name, token);

                break;
        }
    }

    @Override
    public void showxiugai(XiugaiBean list) {
        if (list.getCode().equals("0")) {
            Toast.makeText(this, "成功" + list.getCode(), Toast.LENGTH_SHORT).show();
            SharedPreferences ppp = getSharedPreferences("PPP", MODE_PRIVATE);
            ppp.edit().putString("name", name).commit();

        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }


    }
}
