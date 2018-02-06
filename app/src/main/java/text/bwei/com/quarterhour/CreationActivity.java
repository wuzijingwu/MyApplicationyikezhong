package text.bwei.com.quarterhour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.fabiao.CrosstalkActivity;

/**
 * Created by dell on 2018/2/5.
 */

public class CreationActivity extends Activity {
    @BindView(R.id.images1)
    ImageView images1;
    @BindView(R.id.images2)
    ImageView images2;
    @BindView(R.id.back_production)
    TextView backProduction;
    @BindView(R.id.quxiao)
    RelativeLayout quxiao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.images1, R.id.images2, R.id.back_production, R.id.quxiao})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.images1:
                Intent intent1 = new Intent(this, InvideoActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.images2:
                Intent intent = new Intent(this, CrosstalkActivity.class);
                startActivity(intent);
                break;
            case R.id.back_production:
                finish();
                break;
            case R.id.quxiao:

                break;
        }
    }
}
