package text.bwei.com.quarterhour.xiangqing;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.fapinlun.FapinlunActivity;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.fragment.Eventkkk;
import text.bwei.com.quarterhour.joke.adapter.MyjokeAdapter;
import text.bwei.com.quarterhour.joke.bean.JokeBean;
import text.bwei.com.quarterhour.joke.presenter.presenterjoke;
import text.bwei.com.quarterhour.joke.view.Ijokeview;
import text.bwei.com.quarterhour.utils.Api;
import text.bwei.com.quarterhour.xiangqing.bean.DianzanBean;
import text.bwei.com.quarterhour.xiangqing.bean.ParBean;
import text.bwei.com.quarterhour.xiangqing.presenter.dianzanpresenter;
import text.bwei.com.quarterhour.xiangqing.presenter.parpresenter;
import text.bwei.com.quarterhour.xiangqing.view.Idianzanview;
import text.bwei.com.quarterhour.xiangqing.view.Iparview;

/**
 * Created by dell on 2018/2/6.
 * <p>
 * 详情，视频的
 */

public class ParticularsActivity extends Activity implements Iparview, Ijokeview, Idianzanview {
    @BindView(R.id.image_par)
    SimpleDraweeView imagePar;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.dianzan3)
    ImageView dianzan3;
    @BindView(R.id.recycler_par)
    RecyclerView recyclerPar;
    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.pinlunssss)
    ImageView pinlunssss;
    private int wid;
    private text.bwei.com.quarterhour.xiangqing.presenter.parpresenter parpresenter;
    private text.bwei.com.quarterhour.joke.presenter.presenterjoke presenterjoke;
    public int page = 1;
    private text.bwei.com.quarterhour.xiangqing.presenter.dianzanpresenter dianzanpresenter;
    private int uid;
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
//        parpresenter parpresenter = new parpresenter(this);
        parpresenter = new parpresenter(this);
        presenterjoke = new presenterjoke(this);
        presenterjoke.getjoke(Api.URL, page);
        imagePar.setImageURI("http://img0.imgtn.bdimg.com/it/u=2097996470,2706206864&fm=27&gp=0.jpg");

        dianzanpresenter = new dianzanpresenter(this);


    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void dddff(Eventkkk eventkkk) {
        wid = eventkkk.getWid();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.image_par, R.id.button, R.id.dianzan3, R.id.recycler_par, R.id.imageView6, R.id.pinlunssss})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.image_par:
                break;
            case R.id.button:

//                String url, String uid, String followId, String token

                SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
//                sp.edit().putString("name", list.getMobile())
//                        .putInt("uid", list.getUid())
//                        .putString("pwd", list.getPassword())
//                        .putString("token", list.getToken()).commit();
                uid = user.getInt("uid", 1);
                token = user.getString("token", "000");
                parpresenter.getpar(Api.URL, uid + "", wid + "", token);

                break;
            case R.id.dianzan3:

//                https://www.zhaoapi.cn/quarter/praise?uid=11275&wid=250&
                // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101

                dianzanpresenter.dianzan(Api.URL, uid + "", wid + "", token);


                break;
            case R.id.recycler_par:
                break;
            case R.id.imageView6:
                break;
            case R.id.pinlunssss:
                Intent intent = new Intent(this, FapinlunActivity.class);
                startActivity(intent);


                break;
        }
    }


    @Override
    public void showPar(ParBean list) {

        if (list.getCode().equals("0")) {
            Toast.makeText(this, "成功" + list.getCode(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showjokeSuccess(List<JokeBean.DataBean> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerPar.setLayoutManager(linearLayoutManager);
        recyclerPar.setAdapter(new MyjokeAdapter(list, this));


    }

    @Override
    public void showdianzan(DianzanBean list) {
        if (list.getCode().equals("0")) {
            Toast.makeText(this, "成功" + list.getMsg(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "失败" + list.getMsg(), Toast.LENGTH_SHORT).show();
        }


    }
}
