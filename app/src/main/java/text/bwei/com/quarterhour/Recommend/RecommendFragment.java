package text.bwei.com.quarterhour.Recommend;

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
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.fragment.AttentionFragment;
import text.bwei.com.quarterhour.hot.HotFragment;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.fragment.AttentionFragment;
//import text.bwei.com.uuest.hot.HotFragment;

/**
 * Created by dell on 2018/1/24.
 * 推荐
 */

public class RecommendFragment extends Fragment {


    @BindView(R.id.tab_recommend)
    TabLayout tabRecommend;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private View view;
    private Unbinder unbinder;

    String[] strings = new String[]{"热门", "关注"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.recommendfragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < strings.length; i++) {
            tabRecommend.addTab(tabRecommend.newTab().setText(strings[i]));
        }

        viewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (strings[position]) {
                    case "热门":
                        fragment = new HotFragment();
                        break;
                    case "关注":
                        fragment = new AttentionFragment();
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

        tabRecommend.setupWithViewPager(viewpager);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
