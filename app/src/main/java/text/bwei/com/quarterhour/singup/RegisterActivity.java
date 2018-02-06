package text.bwei.com.quarterhour.singup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.MainActivity;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.singup.bean.SingUpBean;
import text.bwei.com.quarterhour.singup.presenter.Singuppresenter;
import text.bwei.com.quarterhour.singup.view.ISingUpview;
import text.bwei.com.quarterhour.utils.Api;
import text.bwei.com.quarterhour.utils.Toasts;

/**
 * Created by dell on 2018/2/4.
 */

public class RegisterActivity extends Activity implements ISingUpview {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.yiyou)
    TextView yiyou;
    @BindView(R.id.ding)
    RelativeLayout ding;
    @BindView(R.id.ding1)
    LinearLayout ding1;
    @BindView(R.id.zhucezhanghao)
    EditText zhucezhanghao;
    @BindView(R.id.zhucemima)
    EditText zhucemima;
    @BindView(R.id.ding2)
    LinearLayout ding2;
    @BindView(R.id.zhuce)
    Button zhuce;
    @BindView(R.id.youke)
    TextView youke;
    private Singuppresenter singuppresenter;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        singuppresenter = new Singuppresenter(this);
    }

    @OnClick({R.id.fanhui, R.id.yiyou, R.id.ding, R.id.ding1, R.id.zhucezhanghao, R.id.zhucemima, R.id.ding2, R.id.zhuce, R.id.youke})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                RegisterActivity.this.setResult(5);
                finish();
                break;
            case R.id.yiyou:
                break;
            case R.id.ding:
                break;
            case R.id.ding1:
                break;
            case R.id.zhucezhanghao:
                break;
            case R.id.zhucemima:
                break;
            case R.id.ding2:
                break;
            case R.id.zhuce:
                name = zhucezhanghao.getText().toString().trim();
                pwd = zhucemima.getText().toString().trim();
                singuppresenter.onSingUp(Api.URL, name, pwd);
                break;
            case R.id.youke:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

//    @Override
//    public void ShowSign() {
////        Toasts.showLong(this, "注册成功");
//        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
//
//    }

//    @Override
//    public void ShowSign(SingUpBean list) {
////        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
////        Toasts.showLong(this, "注册成功");
//        if (name == null) {
//            Toast.makeText(this, "账户为空", Toast.LENGTH_SHORT).show();
//        }
//        if (pwd == null) {
//            Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
//        }
//
//    }


    @Override
    public void ShowSign(SingUpBean list) {
        if (list.getCode().equals("0")) {
            Toast.makeText(this, "注册成功" + list.getMsg(), Toast.LENGTH_SHORT).show();
        }
        if (list.getCode().equals("1")) {
            Toast.makeText(this, "注册失败" + list.getMsg(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void ShowError(String e) {
        Toasts.showLong(this, e);
        Log.e("哈哈哈哈啊哈哈哈哈哈哈哈", e);
    }
}
