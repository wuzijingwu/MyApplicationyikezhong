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
import text.bwei.com.quarterhour.sousuo.bean.HuanyipiBean;

/**
 * Created by dell on 2018/2/6.
 */

public class MyhuanyipiAdapter extends RecyclerView.Adapter {
    List<HuanyipiBean.DataBean> list;
    Context context;

    public MyhuanyipiAdapter(List<HuanyipiBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.huanyipi_item, parent, false);
        return new Myhuanyipiview(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Myhuanyipiview myhuanyipiview = (Myhuanyipiview) holder;
        myhuanyipiview.textHuanyipi.setText(list.get(position).getUsername());
        myhuanyipiview.imageHuanyipi.setImageURI("http://p1.so.qhmsg.com/bdr/_240_/t010887fe3569a49636.jpg");


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class Myhuanyipiview extends RecyclerView.ViewHolder {
        @BindView(R.id.image_huanyipi)
        SimpleDraweeView imageHuanyipi;
        @BindView(R.id.text_huanyipi)
        TextView textHuanyipi;

        public Myhuanyipiview(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
