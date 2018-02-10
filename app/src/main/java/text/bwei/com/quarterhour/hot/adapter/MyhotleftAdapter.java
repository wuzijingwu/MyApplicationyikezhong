package text.bwei.com.quarterhour.hot.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.fragment.Eventkkk;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
import text.bwei.com.quarterhour.xiangqing.ParticularsActivity;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.hot.bean.HotLeftBean;

/**
 * Created by dell on 2018/1/24.
 */

public class MyhotleftAdapter extends RecyclerView.Adapter {

    List<HotLeftBean.DataBean> list;
    Context context;
    int i = 1;
    private MyViewHolder myViewHolder;

    public MyhotleftAdapter(List<HotLeftBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotfragment_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        myViewHolder = (MyViewHolder) holder;

//        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        myViewHolder.videoplayer.TOOL_BAR_EXIST = false;
        myViewHolder.videoplayer.setUp(list.get(position).getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        myViewHolder.videoplayer.loop = true;//是否循环播放

        Glide.with(context).load(list.get(position).getCover())
                .into(myViewHolder.videoplayer.thumbImageView);
        myViewHolder.videoplayer.widthRatio = 4;//播放比例
        myViewHolder.videoplayer.heightRatio = 3;
        myViewHolder.imageHot.setImageURI(list.get(position).getCover());
        myViewHolder.imageHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ParticularsActivity.class);
                EventBus.getDefault().postSticky(new Eventkkk(list.get(position).getWid()));
                context.startActivity(intent);
            }
        });

        if (list.get(position).getWorkDesc() == null) {

            myViewHolder.textView3.setText("哈哈");
        } else {
            myViewHolder.textView3.setText(list.get(position).getWorkDesc());
        }
        myViewHolder.textTime.setText(list.get(position).getCreateTime());


        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(myViewHolder.image, "rotation", 0f, 360f);

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
                            myViewHolder.image.setImageResource(R.mipmap.jia);
                            setDongHua1();
                            i++;
                        } else {
                            myViewHolder.image.setImageResource(R.mipmap.jian);
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

    public void setDongHua1() {
        Log.d("MainActivity", "jian");
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(myViewHolder.p, "rotation", 0f, 360f);
        ObjectAnimator a1 = ObjectAnimator.ofFloat(myViewHolder.p, "translationX", -180, 0);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(a1, animator1);//同时执行
        set.setDuration(1000);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myViewHolder.p.setVisibility(View.INVISIBLE);
            }
        });


        ObjectAnimator animator2 = ObjectAnimator.ofFloat(myViewHolder.f, "rotation", 0f, 360f);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(myViewHolder.f, "translationX", -130, 0);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(a2, animator2);//同时执行
        set2.setDuration(1000);
        set2.start();
        set2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myViewHolder.f.setVisibility(View.INVISIBLE);
            }
        });

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(myViewHolder.j, "rotation", 0f, 360f);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(myViewHolder.j, "translationX", -80, 0);
        AnimatorSet set3 = new AnimatorSet();
        set3.playTogether(a3, animator3);//同时执行
        set3.setDuration(1000);
        set3.start();
        set3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myViewHolder.j.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void setDongHua() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(myViewHolder.p, "rotation", 0f, 360f);
        ObjectAnimator a1 = ObjectAnimator.ofFloat(myViewHolder.p, "translationX", 0, -180);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(a1, animator1);//同时执行
        set.setDuration(1000);
        set.start();
        myViewHolder.p.setVisibility(View.VISIBLE);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(myViewHolder.f, "rotation", 0f, 360f);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(myViewHolder.f, "translationX", 0, -130);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(a2, animator2);//同时执行
        set2.setDuration(1000);
        set2.start();
        myViewHolder.f.setVisibility(View.VISIBLE);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(myViewHolder.j, "rotation", 0f, 360f);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(myViewHolder.j, "translationX", 0, -80);
        AnimatorSet set3 = new AnimatorSet();
        set3.playTogether(a3, animator3);//同时执行
        set3.setDuration(1000);
        set3.start();
        myViewHolder.j.setVisibility(View.VISIBLE);
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_hot)
        SimpleDraweeView imageHot;
        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.videoplayer)
        JCVideoPlayerStandard videoplayer;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.p)
        ImageView p;
        @BindView(R.id.f)
        ImageView f;
        @BindView(R.id.j)
        ImageView j;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
