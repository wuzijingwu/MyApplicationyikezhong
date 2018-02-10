package text.bwei.com.quarterhour;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.quarterhour.bendi.NativeFragment;
import text.bwei.com.quarterhour.fragment.UploadingFragment;

/**
 * Created by dell on 2018/2/2.
 */

public class ProductionActivity extends AppCompatActivity {

    @BindView(R.id.back_production)
    SimpleDraweeView backProduction;
    @BindView(R.id.ding)
    RelativeLayout ding;
    @BindView(R.id.tablayout_production)
    TabLayout tablayoutProduction;
    @BindView(R.id.viewpager_production)
    ViewPager viewpagerProduction;
    String[] strings = new String[]{"本地作品", "已上传"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);
        ButterKnife.bind(this);

        for (int i = 0; i < strings.length; i++) {
            tablayoutProduction.addTab(tablayoutProduction.newTab().setText(strings[i]));
        }

        viewpagerProduction.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (strings[position]) {
                    case "本地作品":
                        //本地
                        fragment = new NativeFragment();
                        break;
                    case "已上传":
                        //上传
                        fragment = new UploadingFragment();
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

        tablayoutProduction.setupWithViewPager(viewpagerProduction);


    }

    @OnClick({R.id.back_production, R.id.ding, R.id.tablayout_production, R.id.viewpager_production})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_production:
                ProductionActivity.this.setResult(1);
                finish();
                break;
            case R.id.ding:
                break;
            case R.id.tablayout_production:
                break;
            case R.id.viewpager_production:
                break;
        }
    }
}
