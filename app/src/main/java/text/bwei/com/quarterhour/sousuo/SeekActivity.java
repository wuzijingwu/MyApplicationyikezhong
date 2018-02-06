package text.bwei.com.quarterhour.sousuo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.sousuo.adapter.MySeekadapter;
import text.bwei.com.quarterhour.sousuo.adapter.MyhuanyipiAdapter;
import text.bwei.com.quarterhour.sousuo.bean.HuanyipiBean;
import text.bwei.com.quarterhour.sousuo.bean.SeekBean;
import text.bwei.com.quarterhour.sousuo.presenter.Huanyipipresenter;
import text.bwei.com.quarterhour.sousuo.presenter.Seekpresenter;
import text.bwei.com.quarterhour.sousuo.view.IInabatchview;
import text.bwei.com.quarterhour.sousuo.view.ISeekview;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/6.
 * <p>
 * 搜索
 */

public class SeekActivity extends Activity implements ISeekview, IInabatchview {

    @BindView(R.id.back_production)
    TextView backProduction;
    @BindView(R.id.ed_seek)
    EditText edSeek;
    @BindView(R.id.image_seek)
    ImageView imageSeek;
    @BindView(R.id.recycler_seek)
    RecyclerView recyclerSeek;
    Seekpresenter seekpresenter;
    @BindView(R.id.recycler_seek2)
    RecyclerView recyclerSeek2;
    @BindView(R.id.huanyihuan)
    TextView huanyihuan;
    private LinearLayoutManager linearLayoutManager;
    private Huanyipipresenter huanyipipresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        seekpresenter = new Seekpresenter(this);

        huanyipipresenter = new Huanyipipresenter(this);


    }


    @OnClick({R.id.back_production, R.id.ed_seek, R.id.image_seek, R.id.recycler_seek, R.id.recycler_seek2, R.id.huanyihuan})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_production:
                break;
            case R.id.ed_seek:
                break;
            case R.id.image_seek:
                String name = edSeek.getText().toString().trim();
                seekpresenter.getSeek(Api.URL, name, 1 + "");
                break;
            case R.id.recycler_seek:
                break;
            case R.id.recycler_seek2:
                break;
            case R.id.huanyihuan:
                huanyipipresenter.gethuanyipi(Api.URL);
                break;
        }
    }

    @Override
    public void showSeek(List<SeekBean.DataBean> list) {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerSeek.setLayoutManager(linearLayoutManager);
        recyclerSeek.setAdapter(new MySeekadapter(list, this));
    }


    @Override
    public void showhunayipi(List<HuanyipiBean.DataBean> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerSeek2.setLayoutManager(linearLayoutManager);
        recyclerSeek2.setAdapter(new MyhuanyipiAdapter(list, this));
    }
}
