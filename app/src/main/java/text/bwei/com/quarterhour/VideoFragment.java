package text.bwei.com.quarterhour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.hots.HotsFragment;
import text.bwei.com.quarterhour.near.NearbyFragment;
//import text.bwei.com.uuest.hots.HotsFragment;
//import text.bwei.com.uuest.near.NearbyFragment;

/**
 * Created by dell on 2018/1/24.
 * 视屏
 */

public class VideoFragment extends Fragment {
    @BindView(R.id.tab_videl)
    TabLayout tabVidel;
    @BindView(R.id.viewpager_video)
    ViewPager viewpagerVideo;
    private View view;
    private Unbinder unbinder;

    String[] strings = new String[]{"热门", "附近"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.videofragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < strings.length; i++) {
            tabVidel.addTab(tabVidel.newTab().setText(strings[i]));
        }

        viewpagerVideo.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (strings[position]) {
                    case "热门":
                        fragment = new HotsFragment();
                        break;
                    case "附近":
                        fragment = new NearbyFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return strings.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strings[position];
            }
        });

        tabVidel.setupWithViewPager(viewpagerVideo);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
