package app.simplypay.demoapp;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;
import com.orm.SugarApp;
import app.simplypay.demoapp.api.ApiManager;

/**
 * Created by jagadeeshakn on 3/16/2016.
 */
public class App extends SugarApp {

    public static final Map<Integer, Typeface> typefaceManager = new HashMap<>();

    public static ApiManager apiManager;

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        apiManager = new ApiManager();
    }

    public static Context getContext() {
        return instance;
    }

    public static App getInstance() {
        return instance;
    }

}
