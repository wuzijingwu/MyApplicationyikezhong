package text.bwei.com.quarterhour.singup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.MainActivity;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.singup.bean.LoginBean;
import text.bwei.com.quarterhour.singup.presenter.Loginpresenter;
import text.bwei.com.quarterhour.singup.view.ILonginview;
import text.bwei.com.quarterhour.utils.Api;
import text.bwei.com.quarterhour.utils.Toasts;

/**
 * Created by dell on 2018/2/4.
 */

public class LogintwoActivity extends Activity implements ILonginview {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.ding)
    RelativeLayout ding;
    @BindView(R.id.ding1)
    LinearLayout ding1;
    @BindView(R.id.zhanghao)
    EditText zhanghao;
    @BindView(R.id.mima)
    EditText mima;
    @BindView(R.id.ding2)
    LinearLayout ding2;
    @BindView(R.id.deng)
    Button deng;
    @BindView(R.id.wangji)
    TextView wangji;
    @BindView(R.id.ding3)
    RelativeLayout ding3;
    @BindView(R.id.youke)
    TextView youke;
    private Loginpresenter loginpresenter;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng2);
        ButterKnife.bind(this);
        //登陆的处理层
        loginpresenter = new Loginpresenter(this);


    }

    @OnClick({R.id.fanhui, R.id.zhuce, R.id.ding, R.id.ding1, R.id.zhanghao, R.id.mima, R.id.ding2, R.id.deng, R.id.wangji, R.id.ding3, R.id.youke})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                LogintwoActivity.this.setResult(4);
                finish();
                break;
            case R.id.zhuce:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent, 5);
                finish();
                break;
            case R.id.ding:
                break;
            case R.id.ding1:
                break;
            case R.id.zhanghao:
                break;
            case R.id.mima:
                break;
            case R.id.ding2:
                break;
            case R.id.deng:
                name = zhanghao.getText().toString().trim();
                pwd = mima.getText().toString().trim();
                loginpresenter.getLogin(Api.URL, name, pwd);
                break;
            case R.id.wangji:
                Intent intent2 = new Intent(this, PwdActivity.class);
                startActivity(intent2);
                finish();

                break;
            case R.id.ding3:
                break;
            case R.id.youke:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                finish();

                break;
        }
    }

    @Override
    public void showLoginsuccess(LoginBean.DataBean list) {
        SharedPreferences sp = getSharedPreferences("USER", MODE_PRIVATE);
        sp.edit().putString("name", list.getMobile())
                .putInt("uid", list.getUid())
                .putString("pwd", list.getPassword())
                .putString("token", list.getToken()).commit();
        Toasts.showLong(this, "登录成功");
        finish();
    }

    @Override
    public void showLoginError() {

    }
}
