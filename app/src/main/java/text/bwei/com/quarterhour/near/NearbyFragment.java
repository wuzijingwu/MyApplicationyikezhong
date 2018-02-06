package text.bwei.com.quarterhour.near;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.R;
//import text.bwei.com.uuest.R;

/**
 * Created by dell on 2018/1/26.
 */

public class NearbyFragment extends Fragment {
    @BindView(R.id.recycler_nearby)
    RecyclerView recyclerNearby;
    private View view;
    private Unbinder unbinder;

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
//        prsenternear prsenternear = new prsenternear(this);
//        prsenternear.getnear(Api.URL, 1, 39.92, 116.46);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
