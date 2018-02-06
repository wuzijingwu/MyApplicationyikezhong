package text.bwei.com.quarterhour;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import text.bwei.com.quarterhour.Recommend.RecommendFragment;
import text.bwei.com.quarterhour.joke.JokeFragment;

import static text.bwei.com.quarterhour.R.id.btb;
import static text.bwei.com.quarterhour.R.id.chouti;
import static text.bwei.com.quarterhour.R.id.dra;
import static text.bwei.com.quarterhour.R.id.touxiang;
import static text.bwei.com.quarterhour.R.id.ziti;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView mTouxiang;
    /**
     * 推荐
     */
    private TextView mZiti;
    private SimpleDraweeView mBian;
    private RelativeLayout mDing;
    private BottomTabBar mBtb;
    private FrameLayout mFl2;
    private LinearLayout mChouti;
    private DrawerLayout mDra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreationActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    private void initView() {
        mTouxiang = (SimpleDraweeView) findViewById(touxiang);
        mZiti = (TextView) findViewById(ziti);
        mBian = (SimpleDraweeView) findViewById(R.id.bian);
        mDing = (RelativeLayout) findViewById(R.id.ding);
        mBtb = (BottomTabBar) findViewById(btb);
        mFl2 = (FrameLayout) findViewById(R.id.fl2);
        mChouti = (LinearLayout) findViewById(chouti);
        mDra = (DrawerLayout) findViewById(dra);


        mBtb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.mipmap.ic_launcher, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.ic_launcher, JokeFragment.class)
                .addTabItem("视频", R.mipmap.ic_launcher, VideoFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        mZiti.setText(name);
                    }
                });
        //打开抽屉按钮
        mTouxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDra.openDrawer(mChouti);
            }
        });


        //抽屉的布局
        getSupportFragmentManager().beginTransaction().replace(R.id.fl2, new SlideOverFragment()).commit();


    }
}
