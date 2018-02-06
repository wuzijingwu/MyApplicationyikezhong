package text.bwei.com.quarterhour.joke.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.joke.bean.JokeBean;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.joke.bean.JokeBean;

/**
 * Created by dell on 2018/1/26.
 */

public class MyjokeAdapter extends RecyclerView.Adapter {

    List<JokeBean.DataBean> list;
    Context context;
    private boolean isVisible = true;
    private Myjokeview myjokeview;

    public MyjokeAdapter(List<JokeBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.jokefragment_item, parent, false);
        return new Myjokeview(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        myjokeview = (Myjokeview) holder;
        myjokeview.textBinlun.setText(list.get(position).getContent());
        myjokeview.button2.setVisibility(View.INVISIBLE);
        myjokeview.button3.setVisibility(View.INVISIBLE);
        myjokeview.button4.setVisibility(View.INVISIBLE);
        myjokeview.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isVisible) {
                    myjokeview.button2.setVisibility(View.VISIBLE);
                    myjokeview.button3.setVisibility(View.VISIBLE);
                    myjokeview.button4.setVisibility(View.VISIBLE);
                    isVisible = false;
                } else {
                    myjokeview.button2.setVisibility(View.INVISIBLE);
                    myjokeview.button3.setVisibility(View.INVISIBLE);
                    myjokeview.button4.setVisibility(View.INVISIBLE);
                    isVisible = true;
                }
            }
        });
//        list.get(position).getUser().getIcon().toString()
        Object icon = list.get(position).getUser().getIcon();
        if (icon != null) {
            myjokeview.sdvImageCircle.setImageURI(icon.toString());
        } else {
            myjokeview.sdvImageCircle.setImageResource(R.drawable.copylink1);
        }

        myjokeview.textTime.setText(list.get(position).getCreateTime());
        myjokeview.textName.setText(list.get(position).getUser().getNickname());


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class Myjokeview extends RecyclerView.ViewHolder {

        @BindView(R.id.sdv_image_circle)
        SimpleDraweeView sdvImageCircle;
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_time)
        TextView textTime;
        @BindView(R.id.button1)
        Button button1;
        @BindView(R.id.button2)
        Button button2;
        @BindView(R.id.button3)
        Button button3;
        @BindView(R.id.button4)
        Button button4;
        @BindView(R.id.text_binlun)
        TextView textBinlun;

        public Myjokeview(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
