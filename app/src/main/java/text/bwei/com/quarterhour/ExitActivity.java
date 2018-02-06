package text.bwei.com.quarterhour;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dell on 2018/2/5.
 */

public class ExitActivity extends Activity {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.tuichu)
    Button tuichu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.fanhui, R.id.tuichu})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                ExitActivity.this.setResult(8);
                finish();


                break;
            case R.id.tuichu:
                SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
                user.edit().clear().commit();
//                finish();
                break;
        }
    }
}
