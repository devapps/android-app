package app.simplypay.demoapp.api;

import android.util.Log;

import app.simplypay.demoapp.objects.User;
import retrofit.Callback;

/**
 * Created by jagadeeshakn on 3/16/2016.
 */
public class ApiManager extends BaseApiManager {

    public void login(String username, String password,boolean shouldByPassSSLSecurity, Callback<User> callback) {
        Log.i(getClass().getSimpleName(), "Login - " + username + " Password - " + password);
        getAuthApi(shouldByPassSSLSecurity).authenticate(username, password, callback);
    }

}
