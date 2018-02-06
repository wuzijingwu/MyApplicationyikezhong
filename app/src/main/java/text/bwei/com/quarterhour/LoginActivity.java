package text.bwei.com.quarterhour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.singup.LogintwoActivity;

/**
 * Created by dell on 2018/2/2.
 */

public class LoginActivity extends Activity {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.ding)
    LinearLayout ding;
    @BindView(R.id.ding1)
    LinearLayout ding1;
    @BindView(R.id.weixin)
    SimpleDraweeView weixin;
    @BindView(R.id.qq)
    SimpleDraweeView qq;
    @BindView(R.id.qita)
    TextView qita;
    @BindView(R.id.ding2)
    LinearLayout ding2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.fanhui, R.id.ding, R.id.ding1, R.id.weixin, R.id.qq, R.id.qita, R.id.ding2})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                LoginActivity.this.setResult(3);
                finish();
                break;
            case R.id.ding:
                break;
            case R.id.ding1:
                break;
            case R.id.weixin:
                break;
            case R.id.qq:
                break;
            case R.id.qita:
//                Intent intents = new Intent(getActivity(), LoginActivity.class);
//                startActivityForResult(intents, 3);
                Intent intent = new Intent(this, LogintwoActivity.class);
                startActivityForResult(intent, 4);
                finish();
                break;
            case R.id.ding2:
                break;
        }
    }
}
