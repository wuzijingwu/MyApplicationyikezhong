package text.bwei.com.quarterhour.near.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.near.bean.NearBean;

/**
 * Created by dell on 2018/2/7.
 */

public class MynearAdapter extends RecyclerView.Adapter {
    List<NearBean.DataBean> data;
    Context context;

    public MynearAdapter(List<NearBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mynear_item, parent, false);
        return new MyViewhol(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewhol myViewhol = (MyViewhol) holder;
        myViewhol.videoplayerNear.TOOL_BAR_EXIST = false;
        myViewhol.videoplayerNear.setUp(data.get(position).getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        myViewhol.videoplayerNear.loop = true;//是否循环播放

        Glide.with(context).load(data.get(position).getCover())
                .into(myViewhol.videoplayerNear.thumbImageView);
        myViewhol.videoplayerNear.widthRatio = 4;//播放比例
        myViewhol.videoplayerNear.heightRatio = 5;

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class MyViewhol extends RecyclerView.ViewHolder {

        @BindView(R.id.videoplayer_near)
        JCVideoPlayerStandard videoplayerNear;

        public MyViewhol(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }


}
