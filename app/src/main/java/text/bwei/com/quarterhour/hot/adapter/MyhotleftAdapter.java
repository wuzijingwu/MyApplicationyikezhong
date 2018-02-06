package text.bwei.com.quarterhour.hot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.hot.bean.HotLeftBean;

/**
 * Created by dell on 2018/1/24.
 */

public class MyhotleftAdapter extends RecyclerView.Adapter {

    List<HotLeftBean.DataBean> list;
    Context context;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

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

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_hot)
        SimpleDraweeView imageHot;
        @BindView(R.id.videoplayer)
        JCVideoPlayerStandard videoplayer;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.text_time)
        TextView textTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
