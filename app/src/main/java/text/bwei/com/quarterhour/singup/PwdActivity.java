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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.singup.bean.PwdBean;
import text.bwei.com.quarterhour.singup.presenter.Pwdpresenter;
import text.bwei.com.quarterhour.singup.view.IPwdview;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/5.
 */

public class PwdActivity extends Activity implements IPwdview {

    @BindView(R.id.fanhui_set)
    ImageView fanhuiSet;
    @BindView(R.id.zhuce_set)
    TextView zhuceSet;
    @BindView(R.id.ding_set)
    RelativeLayout dingSet;
    @BindView(R.id.ding1_set)
    LinearLayout ding1Set;
    @BindView(R.id.zhanghao_set)
    EditText zhanghaoSet;
    @BindView(R.id.mima1_set)
    EditText mima1Set;
    @BindView(R.id.mima2_set)
    EditText mima2Set;
    @BindView(R.id.ding2_set)
    LinearLayout ding2Set;
    @BindView(R.id.deng_set)
    Button dengSet;
    @BindView(R.id.ding3_set)
    RelativeLayout ding3Set;
    @BindView(R.id.youke_set)
    TextView youkeSet;
    private Pwdpresenter pwdpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangji);
        ButterKnife.bind(this);
        //重置密码
        pwdpresenter = new Pwdpresenter(this);


    }


    @Override
    public void showPwd(PwdBean list) {
        if (list.getMsg().equals("密码修改成功")) {
            Toast.makeText(this, "修改成功" + list.getCode(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "失败" + list.getCode(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void showErrorpwd(String s) {

    }

    @OnClick({R.id.fanhui_set, R.id.zhuce_set, R.id.ding_set, R.id.ding1_set, R.id.zhanghao_set, R.id.mima1_set, R.id.mima2_set, R.id.ding2_set, R.id.deng_set, R.id.ding3_set, R.id.youke_set})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui_set:
                Intent intent = new Intent(this, LogintwoActivity.class);
                startActivity(intent);
                finish();


                break;
            case R.id.zhuce_set:
                break;
            case R.id.ding_set:
                break;
            case R.id.ding1_set:
                break;
            case R.id.zhanghao_set:
                break;
            case R.id.mima1_set:
                break;
            case R.id.mima2_set:
                break;
            case R.id.ding2_set:
                break;
            case R.id.deng_set:
                String name = zhanghaoSet.getText().toString().trim();
                String mima1 = mima1Set.getText().toString().trim();
                String mima2 = mima2Set.getText().toString().trim();
//                SharedPreferences sp = getSharedPreferences("USER", MODE_PRIVATE);
//                sp.edit().putString("name", list.getMobile())
//                        .putInt("uid", list.getUid())
//                        .putString("pwd", list.getPassword())
//                        .putString("token", list.getToken()).commit();
                SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
                int uid = user.getInt("uid", 1);
                pwdpresenter.getpwd(Api.URL, uid + "", mima1, mima2);
                break;
            case R.id.ding3_set:
                break;
            case R.id.youke_set:
                break;
        }
    }
}
