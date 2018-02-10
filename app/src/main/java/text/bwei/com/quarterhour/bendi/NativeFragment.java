package text.bwei.com.quarterhour.bendi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.bendi.adapter.MyNativeAdapter;
import text.bwei.com.quarterhour.hot.bean.HotBean;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
import text.bwei.com.quarterhour.hot.presenter.presenterhot;
import text.bwei.com.quarterhour.hot.view.Ihotview;
import text.bwei.com.quarterhour.utils.Api;

/**
 * Created by dell on 2018/2/2.
 */

public class NativeFragment extends Fragment implements Ihotview {

    @BindView(R.id.recycler_native)
    RecyclerView recyclerNative;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.p)
    ImageView p;
    @BindView(R.id.f)
    ImageView f;
    @BindView(R.id.j)
    ImageView j;
    private View view;
    private Unbinder unbinder;
    private text.bwei.com.quarterhour.bendi.presenter.nativeprsenter nativeprsenter;
    int i = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_native, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        nativeprsenter = new nativeprsenter(this);
//        nativeprsenter.getnative(Api.URLLL, 6 + "");

        presenterhot presenterhot = new presenterhot(this);
        presenterhot.getHot(Api.URL);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator animator = ObjectAnimator.ofFloat(image, "rotation", 0f, 360f);

                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        // Log.d("MainActivity", "onAnimationStart" );
                        if (i == 0) {
                            image.setImageResource(R.mipmap.mmm);
                            setDongHua1();
                            i++;
                        } else {
                            image.setImageResource(R.mipmap.nnn);
                            setDongHua();
                            i = 0;
                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        super.onAnimationRepeat(animation);

                    }
                });
                animator.setDuration(1000);
                animator.start();
            }
        });


    }

    private void setDongHua1() {
        Log.d("MainActivity", "jian");
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(p, "rotation", 0f, 360f);
        ObjectAnimator a1 = ObjectAnimator.ofFloat(p, "translationX", -100, 0);
        ObjectAnimator aa = ObjectAnimator.ofFloat(p, "translationY", 15, 0);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(a1, animator1);//同时执行
        set.playTogether(aa, animator1);//同时执行
        set.setDuration(1000);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                p.setVisibility(View.INVISIBLE);
            }
        });


        ObjectAnimator animator2 = ObjectAnimator.ofFloat(f, "rotation", 0f, 360f);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(f, "translationX", -80, 0);
        ObjectAnimator aaa = ObjectAnimator.ofFloat(f, "translationY", 70, 0);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(a2, animator2);//同时执行
        set2.playTogether(aaa, animator2);//同时执行
        set2.setDuration(1000);
        set2.start();
        set2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                f.setVisibility(View.INVISIBLE);
            }
        });

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(j, "rotation", 0f, 360f);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(j, "translationX", -25, 0);
        ObjectAnimator aaaa = ObjectAnimator.ofFloat(j, "translationY", 100, 0);
        AnimatorSet set3 = new AnimatorSet();
        set3.playTogether(a3, animator3);//同时执行
        set3.playTogether(aaaa, animator3);//同时执行
        set3.setDuration(1000);
        set3.start();
        set3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                j.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void setDongHua() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(p, "rotation", 0f, 360f);
        ObjectAnimator a1 = ObjectAnimator.ofFloat(p, "translationX", 0, -100);
        ObjectAnimator aC = ObjectAnimator.ofFloat(p, "translationY", 0, 15);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(a1, animator1);//同时执行
        set.playTogether(aC, animator1);//同时执行
        set.setDuration(1000);
        set.start();
        p.setVisibility(View.VISIBLE);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(f, "rotation", 0f, 360f);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(f, "translationX", 0, -80);
        ObjectAnimator aCc = ObjectAnimator.ofFloat(f, "translationY", 0, 70);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(a2, animator2);//同时执行
        set2.playTogether(aCc, animator2);//同时执行
        set2.setDuration(1000);
        set2.start();
        f.setVisibility(View.VISIBLE);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(j, "rotation", 0f, 360f);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(j, "translationX", 0, -25);
        ObjectAnimator aCcc = ObjectAnimator.ofFloat(j, "translationY", 0, 100);
        AnimatorSet set3 = new AnimatorSet();
        set3.playTogether(a3, animator3);//同时执行
        set3.playTogether(aCcc, animator3);//同时执行
        set3.setDuration(1000);
        set3.start();
        j.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.recycler_native, R.id.image, R.id.p, R.id.f, R.id.j})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.recycler_native:
                break;
            case R.id.image:
                break;
            case R.id.p:
                break;
            case R.id.f:
                break;
            case R.id.j:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showHotview(List<HotBean.DataBean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerNative.setLayoutManager(gridLayoutManager);
        recyclerNative.setAdapter(new MyNativeAdapter(list, getActivity()));

    }

    @Override
    public void showHotLeftview(List<HotLeftBean.DataBean> list) {

    }
}
