package haojun.android_common.exception;

import android.app.Application;
import android.content.Context;

// android:name=".exception.MyApplication"
// add to manifests application
public class MyApplication extends Application {

    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static MyApplication getInstance() {
        return instance;
    }
}