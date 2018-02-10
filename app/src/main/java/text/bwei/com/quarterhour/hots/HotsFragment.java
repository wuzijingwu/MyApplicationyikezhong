package text.bwei.com.quarterhour.hots;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.hots.adapter.MyhotsAdapters;
import text.bwei.com.quarterhour.hots.bean.HotsBeans;
import text.bwei.com.quarterhour.hots.presenter.presenterhots;
import text.bwei.com.quarterhour.hots.view.Ihotsview;
import text.bwei.com.quarterhour.utils.Api;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.hots.adapter.MyhotsAdapters;
//import text.bwei.com.uuest.hots.bean.HotsBeans;
//import text.bwei.com.uuest.hots.presenter.presenterhots;
//import text.bwei.com.uuest.hots.view.Ihotsview;
//import text.bwei.com.uuest.utils.Api;

/**
 * Created by dell on 2018/1/26.
 */

public class HotsFragment extends Fragment implements Ihotsview {
    @BindView(R.id.recycler_hots)
    RecyclerView recyclerHots;
    @BindView(R.id.swip_hots)
    SwipeRefreshLayout swipHots;
    private View view;
    private Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    public int page = 1;
    private text.bwei.com.quarterhour.hots.presenter.presenterhots presenterhots;
    private String token;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_hots, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenterhots = new presenterhots(this);
        SharedPreferences user = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);

//        sp.edit().putString("name", list.getMobile())
//                .putInt("uid", list.getUid())
//                .putString("pwd", list.getPassword())
//                .putString("token", list.getToken()).commit();
        token = user.getString("token", "111");

//        "22D1BCB1DB0B5005D059F66F4FDD2238"
        presenterhots.gethotsviews(Api.URL, page, token);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showhotsSuccess(List<HotsBeans.DataBean> list) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerHots.setLayoutManager(staggeredGridLayoutManager);
        recyclerHots.setAdapter(new MyhotsAdapters(list, getActivity()));
        swipHots.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page++;
                presenterhots.gethotsviews(Api.URL, page, token);
                swipHots.setRefreshing(false);
            }
        });

    }

    @OnClick({R.id.recycler_hots, R.id.swip_hots})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.recycler_hots:
                break;
            case R.id.swip_hots:
                break;
        }
    }
}
