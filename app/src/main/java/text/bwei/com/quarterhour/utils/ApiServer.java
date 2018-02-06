package text.bwei.com.quarterhour.utils;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.quarterhour.fabiao.bean.CrosstalkBean;
import text.bwei.com.quarterhour.follow.bean.FollowBean;
import text.bwei.com.quarterhour.hot.bean.HotBean;
import text.bwei.com.quarterhour.hot.bean.HotLeftBean;
import text.bwei.com.quarterhour.hots.bean.HotsBeans;
import text.bwei.com.quarterhour.joke.bean.JokeBean;
import text.bwei.com.quarterhour.near.bean.NearBean;
import text.bwei.com.quarterhour.singup.bean.LoginBean;
import text.bwei.com.quarterhour.singup.bean.PwdBean;
import text.bwei.com.quarterhour.singup.bean.SingUpBean;
import text.bwei.com.quarterhour.sousuo.bean.HuanyipiBean;
import text.bwei.com.quarterhour.sousuo.bean.SeekBean;
//import text.bwei.com.uuest.hot.bean.HotBean;
//import text.bwei.com.uuest.hot.bean.HotLeftBean;
//import text.bwei.com.uuest.hots.bean.HotsBeans;
//import text.bwei.com.uuest.joke.bean.JokeBean;
//import text.bwei.com.uuest.near.bean.NearBean;

/**
 * Created by dell on 2018/1/24.
 */

public interface ApiServer {

    @GET("quarter/getAd")
    Observable<HotBean> gethotdata();

    @POST
    Observable<HotLeftBean> gethotleftdata(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<JokeBean> getjokedata(@Url String url, @QueryMap Map<String, String> map);

    //热门视频
    @POST
    Observable<HotsBeans> getHotsdata(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<NearBean> getneardata(@Url String url, @QueryMap Map<String, String> map);

    //注册
    @POST
    Observable<SingUpBean> getsingupdata(@Url String url, @QueryMap Map<String, String> map);

    //登陆
    @POST
    Observable<LoginBean> getLogindata(@Url String url, @QueryMap Map<String, String> map);

    //忘记密码
    @POST
    Observable<PwdBean> getpwddata(@Url String url, @QueryMap Map<String, String> map);

    //我的关注
    @POST
    Observable<FollowBean> getfollowdata(@Url String url, @QueryMap Map<String, String> map);

    //发表
    @POST
    Observable<CrosstalkBean> getcrosstalkdata(@Url String url, @QueryMap Map<String, String> map);

    //搜索好友
    @POST
    Observable<SeekBean> getseekdata(@Url String url, @QueryMap Map<String, String> map);

    //换一批好友
    @GET("quarter/randomFriends?")
    Observable<HuanyipiBean> gethuanyipiata();

}
