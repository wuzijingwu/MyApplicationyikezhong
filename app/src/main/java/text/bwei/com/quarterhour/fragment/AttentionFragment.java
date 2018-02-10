package text.bwei.com.quarterhour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.hot.adapter.MyhotleftAdapter;
import text.bwei.com.quarterhour.hot.bean.HotBean;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
import text.bwei.com.quarterhour.hot.presenter.presenterhot;
import text.bwei.com.quarterhour.hot.presenter.presenterhotleft;
import text.bwei.com.quarterhour.hot.view.Ihotview;
import text.bwei.com.quarterhour.utils.Api;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.hot.adapter.MyhotleftAdapter;
//import text.bwei.com.uuest.hot.bean.HotBean;
//import text.bwei.com.uuest.hot.bean.HotLeftBean;
//import text.bwei.com.uuest.hot.presenter.presenterhot;
//import text.bwei.com.uuest.hot.presenter.presenterhotleft;
//import text.bwei.com.uuest.hot.view.Ihotview;
//import text.bwei.com.uuest.utils.Api;

/**
 * Created by dell on 2018/1/24.
 */

public class AttentionFragment extends Fragment implements Ihotview {
    @BindView(R.id.banner)
    XBanner banner;
    @BindView(R.id.recycler_hot)
    RecyclerView recyclerHot;
    private View view;
    private Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private text.bwei.com.quarterhour.hot.presenter.presenterhot presenterhot;
    private text.bwei.com.quarterhour.hot.presenter.presenterhotleft presenterhotleft;

//        private text.bwei.com.uuest.hot.presenter.presenterhot presenterhot;
//    private text.bwei.com.uuest.hot.presenter.presenterhotleft presenterhotleft;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.hotfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        banner.setPageTransformer(Transformer.Depth);
        // 设置XBanner页面切换的时间，即动画时长
        banner.setPageChangeDuration(2000);
        presenterhot = new presenterhot(this);
        presenterhot.getHot(Api.URL);

        presenterhotleft = new presenterhotleft(this);
        presenterhotleft.gethotleft(Api.URL, 1, 2);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenterhot.destorys();

    }

    @Override
    public void showHotview(List<HotBean.DataBean> list) {

        List<String> bantitle = new ArrayList<>();
        final List<String> banimg = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            bantitle.add(list.get(i).getTitle());
            banimg.add(list.get(i).getIcon());
        }
        banner.setData(banimg, bantitle);
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(banimg.get(position)).into((ImageView) view);
            }
        });


    }

    @Override
    public void showHotLeftview(List<HotLeftBean.DataBean> list) {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerHot.setLayoutManager(linearLayoutManager);
        recyclerHot.setAdapter(new MyhotleftAdapter(list, getActivity()));
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

//        JCVideoPlayer.setGlobleSkin();//设置全局皮肤
//        videoController.setSkin();//设置这一个播放器的皮肤

    }
}
