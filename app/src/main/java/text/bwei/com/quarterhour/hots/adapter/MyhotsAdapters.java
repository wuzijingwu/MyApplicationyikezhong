package text.bwei.com.quarterhour.hots.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    public MyhotsAdapters(List<HotsBeans.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotsfragment_item, parent, false);
        return new MyhotsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyhotsViewHolder myhotsViewHolder = (MyhotsViewHolder) holder;

//        myhotsViewHolder.videoplayersss.TOOL_BAR_EXIST = false;
//        myhotsViewHolder.videoplayersss.setUp(list.get(position).getVideoUrl()
//                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放视频的标题，可以为空");
////        jcVideoPlayerStandard.loop  = true;//是否循环播放
//
//        Glide.with(context).load(list.get(position).getCover())
//                .into(myhotsViewHolder.videoplayersss.thumbImageView);
//        myhotsViewHolder.videoplayersss.widthRatio = 4;//播放比例
//        myhotsViewHolder.videoplayersss.heightRatio = 3;
        myhotsViewHolder.imageHots.setImageURI(list.get(position).getCover());


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyhotsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_hots)
        SimpleDraweeView imageHots;

        public MyhotsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
