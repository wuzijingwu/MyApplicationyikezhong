package text.bwei.com.quarterhour.hots;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private View view;
    private Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;

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
        presenterhots presenterhots = new presenterhots(this);
        presenterhots.gethotsviews(Api.URL, 2);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showhotsSuccess(List<HotsBeans.DataBean> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerHots.setLayoutManager(linearLayoutManager);
        recyclerHots.setAdapter(new MyhotsAdapters(list, getActivity()));

    }
}
