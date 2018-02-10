package text.bwei.com.quarterhour.bendi.adapter;

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
import text.bwei.com.quarterhour.hot.bean.HotBean;

/**
 * Created by dell on 2018/2/8.
 */

public class MyNativeAdapter extends RecyclerView.Adapter {

    List<HotBean.DataBean> list;
    Context context;
    private Myntive myntive;


    public MyNativeAdapter(List<HotBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_item, parent, false);
        return new Myntive(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myntive = (Myntive) holder;
        myntive.imageNative.setImageURI(list.get(position).getIcon());

    }



    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class Myntive extends RecyclerView.ViewHolder {
        @BindView(R.id.image_native)
        SimpleDraweeView imageNative;


        public Myntive(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
