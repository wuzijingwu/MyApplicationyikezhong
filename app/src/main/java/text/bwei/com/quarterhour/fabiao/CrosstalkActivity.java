package text.bwei.com.quarterhour.fabiao;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.SuccessActivity;
import text.bwei.com.quarterhour.fabiao.bean.CrosstalkBean;
import text.bwei.com.quarterhour.fabiao.presenter.crosstalkpresenter;
import text.bwei.com.quarterhour.fabiao.view.ICrosstalkview;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/5.
 */

public class CrosstalkActivity extends Activity implements ICrosstalkview {
    @BindView(R.id.back_production)
    TextView backProduction;
    @BindView(R.id.fabiao)
    TextView fabiao;
    @BindView(R.id.ding)
    RelativeLayout ding;
    @BindView(R.id.edtid_cross)
    EditText edtidCross;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    private text.bwei.com.quarterhour.fabiao.presenter.crosstalkpresenter crosstalkpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crosstalk);
        ButterKnife.bind(this);
//        https://www.zhaoapi.cn/quarter/publishJoke?uid=11275&content=123456&
        // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
        crosstalkpresenter = new crosstalkpresenter(this);


    }

    @OnClick({R.id.back_production, R.id.fabiao, R.id.ding, R.id.edtid_cross, R.id.imageView3})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_production:
                finish();
                break;
            case R.id.fabiao:
                String yyyy = edtidCross.getText().toString().trim();
////                sp.edit().putString("name", list.getMobile())
////                        .putInt("uid", list.getUid())
////                        .putString("pwd", list.getPassword())
////                        .putString("token", list.getToken()).commit();
                SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
                int uid = user.getInt("uid", 1);
                String token = user.getString("token", "000");
                crosstalkpresenter.getcrosstalk(Api.URL, uid + "", yyyy, token);
//                11275
//                "22D1BCB1DB0B5005D059F66F4FDD2238"

                break;
            case R.id.ding:
                break;
            case R.id.edtid_cross:
                break;
            case R.id.imageView3:

                break;
        }
    }

    @Override
    public void showcrossUccess(CrosstalkBean list) {
        if (list.getMsg().equals("发布成功")) {
            Toast.makeText(this, "成功" + list.getMsg(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SuccessActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void showError(String s) {

    }
}
