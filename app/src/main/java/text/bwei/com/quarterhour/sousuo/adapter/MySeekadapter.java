package text.bwei.com.quarterhour.sousuo.adapter;

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
import text.bwei.com.quarterhour.sousuo.bean.SeekBean;

/**
 * Created by dell on 2018/2/6.
 */

public class MySeekadapter extends RecyclerView.Adapter {

    List<SeekBean.DataBean> list;
    Context context;

    public MySeekadapter(List<SeekBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.seek_item, parent, false);

        return new MyseekView(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyseekView myseekView = (MyseekView) holder;
        myseekView.textSousuo.setText(list.get(position).getNickname());
        if (list.get(position).getIcon() == null) {
            myseekView.imageItem.setImageResource(R.mipmap.ic_launcher);
        } else {
            myseekView.imageItem.setImageURI(list.get(position).getIcon());
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyseekView extends RecyclerView.ViewHolder {
        @BindView(R.id.image_item)
        SimpleDraweeView imageItem;
        @BindView(R.id.text_sousuo)
        TextView textSousuo;

        public MyseekView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
