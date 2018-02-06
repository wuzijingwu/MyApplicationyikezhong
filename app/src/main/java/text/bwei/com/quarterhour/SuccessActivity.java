package text.bwei.com.quarterhour;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dell on 2018/2/6.
 */

public class SuccessActivity extends Activity {
    @BindView(R.id.back_success)
    TextView backSuccess;
    @BindView(R.id.ding)
    RelativeLayout ding;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.kankan)
    Button kankan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.back_success, R.id.ding, R.id.imageView, R.id.textView, R.id.kankan})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_success:
                break;
            case R.id.ding:
                break;
            case R.id.imageView:
                break;
            case R.id.textView:
                break;
            case R.id.kankan:
                break;
        }
    }
}
