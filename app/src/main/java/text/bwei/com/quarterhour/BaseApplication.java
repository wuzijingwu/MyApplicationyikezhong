package text.bwei.com.quarterhour;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}