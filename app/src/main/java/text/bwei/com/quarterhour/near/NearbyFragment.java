package text.bwei.com.quarterhour.near;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.near.adapter.MynearAdapter;
import text.bwei.com.quarterhour.near.bean.NearBean;
import text.bwei.com.quarterhour.near.preaenter.prsenternear;
import text.bwei.com.quarterhour.near.view.Inearview;
import text.bwei.com.quarterhour.utils.Api;
//import text.bwei.com.uuest.R;

/**
 * Created by dell on 2018/1/26.
 */

public class NearbyFragment extends Fragment implements Inearview {
    @BindView(R.id.recycler_nearby)
    RecyclerView recyclerNearby;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swiper;
    private View view;
    private Unbinder unbinder;
    private GridLayoutManager gridLayoutManager;
    private text.bwei.com.quarterhour.near.preaenter.prsenternear prsenternear;
    private GridLayoutManager gridLayoutManager1;
    private int page = 1;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.nearbyfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        https://www.zhaoapi.cn/quarter/getNearVideos?page=1&latitude=1&longitude=1&
        // token=22D1BCB1DB0B5005D059F66F4FDD2238&source=android&appVersion=101
        prsenternear = new prsenternear(this);
        SharedPreferences user = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);
        token = user.getString("token", "111");
        prsenternear.getnear(Api.URL, page + "", 1 + "", 1 + "", token);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void shownearSuccess(final List<NearBean.DataBean> data) {
        gridLayoutManager1 = new GridLayoutManager(getActivity(), 2);
        recyclerNearby.setLayoutManager(gridLayoutManager1);
        recyclerNearby.setAdapter(new MynearAdapter(data, getActivity()));
        swiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page++;
                prsenternear.getnear(Api.URL, page + "", 1 + "", 1 + "", token);
                swiper.setRefreshing(false);
            }
        });

    }

    @Override
    public void showError() {

    }

    @OnClick({R.id.recycler_nearby, R.id.swiper})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.recycler_nearby:
                break;
            case R.id.swiper:
                break;
        }
    }
}
