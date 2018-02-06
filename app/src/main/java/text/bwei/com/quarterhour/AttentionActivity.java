package text.bwei.com.quarterhour;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dell on 2018/2/3.
 */

public class AttentionActivity extends Activity {
    @BindView(R.id.recycler_attention)
    RecyclerView recyclerAttention;
    @BindView(R.id.back_attention)
    SimpleDraweeView backAttention;
    @BindView(R.id.ding)
    RelativeLayout ding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.recycler_attention, R.id.back_attention, R.id.ding})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.recycler_attention:
                break;
            case R.id.back_attention:
                AttentionActivity.this.setResult(2);
                finish();
                break;
            case R.id.ding:
                break;
        }
    }
}
