package text.bwei.com.quarterhour.hots.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.hots.bean.HotsBeans;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.hots.bean.HotsBeans;

/**
 * Created by dell on 2018/1/26.
 */

public class MyhotsAdapters extends RecyclerView.Adapter {

    List<HotsBeans.DataBean> list;
    Context context;

    List<Integer> heightList;


    public MyhotsAdapters(List<HotsBeans.DataBean> list, Context context) {
        this.list = list;
        this.context = context;

        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int height = new Random().nextInt(200) + 100;//[100,300)的随机数
            heightList.add(height);
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotsfragment_item, parent, false);
        return new MyhotsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyhotsViewHolder myhotsViewHolder = (MyhotsViewHolder) holder;
//        if (list.get(position).getCover().equals("")) {
//            myhotsViewHolder.imageHots.setImageResource(R.mipmap.ic_launcher);
//            //.setImageURI("http://i1.umei.cc/uploads/tu/201802/9999/rn0a5cbb706a.jpg");
//        } else {
//            myhotsViewHolder.imageHots.setImageURI(list.get(position).getCover());
//        }
//
        ViewGroup.LayoutParams params = myhotsViewHolder.videoplayerHots.getLayoutParams();
        params.height = heightList.get(position);
        myhotsViewHolder.videoplayerHots.setLayoutParams(params);
        myhotsViewHolder.videoplayerHots.TOOL_BAR_EXIST = false;
        myhotsViewHolder.videoplayerHots.setUp(list.get(position).getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        myhotsViewHolder.videoplayerHots.loop = true;//是否循环播放

        Glide.with(context).load(list.get(position).getCover())
                .into(myhotsViewHolder.videoplayerHots.thumbImageView);
        myhotsViewHolder.videoplayerHots.widthRatio = 4;//播放比例
        myhotsViewHolder.videoplayerHots.heightRatio = 5;

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyhotsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.videoplayer_hots)
        JCVideoPlayerStandard videoplayerHots;

        public MyhotsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
