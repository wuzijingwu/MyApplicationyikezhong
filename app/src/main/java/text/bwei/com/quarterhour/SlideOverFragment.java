package text.bwei.com.quarterhour;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.follow.FollowActivity;
import text.bwei.com.quarterhour.sousuo.SeekActivity;

/**
 * Created by dell on 2018/2/1.
 */

public class SlideOverFragment extends Fragment {
    @BindView(R.id.touxiang)
    SimpleDraweeView touxiang;
    @BindView(R.id.wangming)
    TextView wangming;
    @BindView(R.id.deng)
    RelativeLayout deng;
    @BindView(R.id.gq)
    TextView gq;
    @BindView(R.id.tu1)
    ImageView tu1;
    @BindView(R.id.guanzhu)
    RelativeLayout guanzhu;
    @BindView(R.id.tu2)
    ImageView tu2;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    @BindView(R.id.tu3)
    ImageView tu3;
    @BindView(R.id.sousuo)
    RelativeLayout sousuo;
    @BindView(R.id.tu4)
    ImageView tu4;
    @BindView(R.id.tongzhi)
    RelativeLayout tongzhi;
    @BindView(R.id.tu5)
    ImageView tu5;
    @BindView(R.id.zuopin)
    LinearLayout zuopin;
    @BindView(R.id.shezhi)
    LinearLayout shezhi;
    @BindView(R.id.guanzu)
    TextView guanzu;
    @BindView(R.id.shouchang)
    TextView shouchang;
    @BindView(R.id.shousuo)
    TextView shousuo;
    private View view;
    private Unbinder unbinder;
    private SharedPreferences yikezhong;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.slideoverfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        EventBus.getDefault().register(this);

//        SharedPreferences user = getActivity().getSharedPreferences("USER", MODE_PRIVATE);
//        String name11 = user.getString("name", "000");
//        wangming.setText(name11);

    }

//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
//    public void getloginname(LoginEvent loginEvent) {
//        name = loginEvent.getName();
//    }


//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }


    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences user = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);
//        LoginBean.DataBean dataBean = new LoginBean.DataBean();
        String name = user.getString("name", "000");
        if (!name.equals("000")) {
            wangming.setText(name);
        } else {
            wangming.setText("点击登录");
        }
    }

    @Override
    public void onResume() {
        int id = getActivity().getIntent().getIntExtra("id", 0);
//        if (id == 2) {
//
//        }
        super.onResume();
    }

    @OnClick({R.id.touxiang, R.id.wangming, R.id.deng, R.id.gq, R.id.tu1, R.id.guanzhu, R.id.tu2, R.id.shoucang, R.id.tu3, R.id.sousuo, R.id.tu4, R.id.tongzhi, R.id.tu5, R.id.zuopin, R.id.shezhi, R.id.guanzu, R.id.shouchang, R.id.shousuo})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.touxiang:
                Intent intents = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intents, 3);
                break;
            case R.id.wangming:
                break;
            case R.id.deng:
                break;
            case R.id.gq:
                break;
            case R.id.tu1:
                break;
            case R.id.guanzhu:

                Intent intent2 = new Intent(getActivity(), AttentionActivity.class);
                startActivityForResult(intent2, 2);
//                getActivity().finish();
                break;
            case R.id.tu2:
                break;
            case R.id.shoucang:
                break;
            case R.id.tu3:
                break;
            case R.id.sousuo:

                break;
            case R.id.tu4:
                break;
            case R.id.tongzhi:
                break;
            case R.id.tu5:
                break;
            case R.id.zuopin:
                Intent intent1 = new Intent(getActivity(), ProductionActivity.class);
                startActivityForResult(intent1, 1);
//                getActivity().finish();
                break;
            case R.id.shezhi:
                Intent intentss = new Intent(getActivity(), ExitActivity.class);
                startActivityForResult(intentss, 8);
//                getActivity().finish();


                break;
            case R.id.guanzu:
                Intent intent = new Intent(getActivity(), FollowActivity.class);
                startActivity(intent);


                break;
            case R.id.shouchang:
                break;
            case R.id.shousuo:
                Intent intent3 = new Intent(getActivity(), SeekActivity.class);
                startActivity(intent3);
                break;
        }
    }


}
