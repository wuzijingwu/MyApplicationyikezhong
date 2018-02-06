package text.bwei.com.quarterhour.follow;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.follow.adapter.MyfollowAdapter;
import text.bwei.com.quarterhour.follow.bean.FollowBean;
import text.bwei.com.quarterhour.follow.presenter.followpresenter;
import text.bwei.com.quarterhour.follow.view.Ifollowview;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/5.
 */

public class FollowActivity extends Activity implements Ifollowview {
    @BindView(R.id.back_production)
    SimpleDraweeView backProduction;
    @BindView(R.id.hots)
    TextView hots;
    @BindView(R.id.ding)
    RelativeLayout ding;
    @BindView(R.id.recycler_follow)
    RecyclerView recyclerFollow;
    private text.bwei.com.quarterhour.follow.presenter.followpresenter followpresenter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        ButterKnife.bind(this);
        followpresenter = new followpresenter(this);
        SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
        int uid = user.getInt("uid", 1);
//        sp.edit().putString("name", list.getMobile())
//                .putInt("uid", list.getUid())
//                .putString("pwd", list.getPassword())
//                .putString("token", list.getToken()).commit();
        String token = user.getString("token", "111");

//        "22D1BCB1DB0B5005D059F66F4FDD2238"

        followpresenter.getfollow(Api.URL, uid + "", token);
    }

    @OnClick({R.id.back_production, R.id.hots, R.id.ding, R.id.recycler_follow})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_production:
                break;
            case R.id.hots:
                break;
            case R.id.ding:
                break;
            case R.id.recycler_follow:
                break;
        }
    }

    @Override
    public void showfollow(List<FollowBean.DataBean> data) {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerFollow.setLayoutManager(linearLayoutManager);
        recyclerFollow.setAdapter(new MyfollowAdapter(data, this));
    }
}
