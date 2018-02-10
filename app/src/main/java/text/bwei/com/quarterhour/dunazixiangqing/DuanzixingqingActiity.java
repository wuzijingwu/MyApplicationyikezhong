package text.bwei.com.quarterhour.dunazixiangqing;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.dunazixiangqing.bean.DuanziBean;
import text.bwei.com.quarterhour.dunazixiangqing.presenter.Duanzipresenter;
import text.bwei.com.quarterhour.dunazixiangqing.view.IDuanziview;
import text.bwei.com.quarterhour.joke.bean.EventJid;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/7.
 */

public class DuanzixingqingActiity extends Activity implements IDuanziview {
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.textView2_ttt)
    TextView textView2Ttt;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    private Duanzipresenter duanzipresenter;
    private int jid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_duanzi);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        duanzipresenter = new Duanzipresenter(this);
        duanzipresenter.getduanzi(Api.URL, jid + "");


    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getdddd(EventJid eventJid) {
        jid = eventJid.getJid();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @OnClick({R.id.imageView5, R.id.textView2_ttt, R.id.imageView4})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imageView5:
                break;
            case R.id.textView2_ttt:

                break;
            case R.id.imageView4:
                break;
        }
    }

    @Override
    public void showduanzi(DuanziBean.DataBean list) {
        textView2Ttt.setText(list.getContent());
    }
}
