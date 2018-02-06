package text.bwei.com.quarterhour.joke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import text.bwei.com.quarterhour.R;
import text.bwei.com.quarterhour.joke.adapter.MyjokeAdapter;
import text.bwei.com.quarterhour.joke.bean.JokeBean;
import text.bwei.com.quarterhour.joke.presenter.presenterjoke;
import text.bwei.com.quarterhour.joke.view.Ijokeview;
import text.bwei.com.quarterhour.utils.Api;
//import text.bwei.com.uuest.R;
//import text.bwei.com.uuest.joke.adapter.MyjokeAdapter;
//import text.bwei.com.uuest.joke.bean.JokeBean;
//import text.bwei.com.uuest.joke.presenter.presenterjoke;
//import text.bwei.com.uuest.joke.view.Ijokeview;
//import text.bwei.com.uuest.utils.Api;

/**
 * Created by dell on 2018/1/24.
 * 段子
 */

public class JokeFragment extends Fragment implements Ijokeview {


    @BindView(R.id.recycler_joke)
    RecyclerView recyclerJoke;
    //    @BindView(R.id.sdv_image_circle)
//    SimpleDraweeView sdvImageCircle;
//    @BindView(R.id.text_name)
//    TextView textName;
//    @BindView(R.id.text_time)
//    TextView textTime;
//    @BindView(R.id.button1)
//    Button button1;
//    @BindView(R.id.button2)
//    Button button2;
//    @BindView(R.id.button3)
//    Button button3;
//    @BindView(R.id.button4)
//    Button button4;
    private View view;
    private Unbinder unbinder;

    private LinearLayoutManager linearLayoutManager;
    private text.bwei.com.quarterhour.joke.presenter.presenterjoke presenterjoke;
    //    private text.bwei.com.uuest.joke.presenter.presenterjoke presenterjoke;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.jokefragment, container, false);

        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenterjoke = new presenterjoke(this);
        presenterjoke.getjoke(Api.URL, 1);


    }


//    @OnClick({R.id.sdv_image_circle, R.id.text_name, R.id.text_time, R.id.button1, R.id.button2, R.id.button3, button4})
//    public void onClick(View v) {
//        switch (v.getId()) {
//            default:
//                break;
//            case R.id.sdv_image_circle:
//                break;
//            case R.id.text_name:
//                break;
//            case R.id.text_time:
//                break;
//            case R.id.button1:
//                if (isVisible) {
//                    button2.setVisibility(View.VISIBLE);
//                    button3.setVisibility(View.VISIBLE);
//                    button4.setVisibility(View.VISIBLE);
//                    isVisible = false;
//                } else {
//                    button2.setVisibility(View.INVISIBLE);
//                    button3.setVisibility(View.INVISIBLE);
//                    button4.setVisibility(View.INVISIBLE);
//                    isVisible = true;
//                }
//                break;
//            case R.id.button2:
//
//                break;
//            case R.id.button3:
//                break;
//            case button4:
//                break;
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenterjoke.destorysd();
    }

    @Override
    public void showjokeSuccess(List<JokeBean.DataBean> list) {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerJoke.setLayoutManager(linearLayoutManager);
        recyclerJoke.setAdapter(new MyjokeAdapter(list, getActivity()));
    }
}
