package app.simplypay.utils;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;

import app.simplypay.demoapp.api.BaseApiManager;
import io.fabric.sdk.android.Fabric;

/**
 * Created by conflux37 on 3/16/2016.
 */
public class DemoApplication extends Application {
    public BaseApiManager api;


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
