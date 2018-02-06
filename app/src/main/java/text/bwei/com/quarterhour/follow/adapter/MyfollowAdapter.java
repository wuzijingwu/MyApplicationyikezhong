package text.bwei.com.quarterhour.follow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.follow.bean.FollowBean;

/**
 * Created by dell on 2018/2/5.
 */

public class MyfollowAdapter extends RecyclerView.Adapter {

    List<FollowBean.DataBean> data;
    Context context;

    public MyfollowAdapter(List<FollowBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_item, parent, false);
        return new Myfollowview(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Myfollowview myfollowview = (Myfollowview) holder;
        myfollowview.text1Followitem.setText(data.get(position).getNickname());
//        myfollowview.text2Item.setText(data.get(position).get);
        myfollowview.text3Item.setText(data.get(position).getCreatetime());
        if (data.get(position).getIcon() == null) {

            myfollowview.sdvImageCircle.setImageResource(R.mipmap.ic_launcher_round);

        }
        else{
            myfollowview.sdvImageCircle.setImageURI(data.get(position).getIcon());

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Myfollowview extends RecyclerView.ViewHolder {
        @BindView(R.id.sdv_image_circle)
        SimpleDraweeView sdvImageCircle;
        @BindView(R.id.text1_followitem)
        TextView text1Followitem;
        @BindView(R.id.text2_item)
        TextView text2Item;
        @BindView(R.id.text3_item)
        TextView text3Item;

        public Myfollowview(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
