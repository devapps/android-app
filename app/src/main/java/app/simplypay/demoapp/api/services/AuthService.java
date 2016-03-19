package app.simplypay.demoapp.api.services;

import app.simplypay.demoapp.api.model.APIEndPoint;
import app.simplypay.demoapp.objects.User;
import app.simplypay.demoapp.utils.Constants;
import retrofit.Callback;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by jagadeeshakn on 3/17/2016.
 */
public interface AuthService {
    String ACCEPT_JSON = Constants.ACCEPT_JSON;
    String CONTENT_TYPE_JSON =Constants.CONTENT_TYPE_JSON;

    @Headers({ACCEPT_JSON, CONTENT_TYPE_JSON})

    @POST(APIEndPoint.AUTHENTICATION)
    void authenticate(@Query("username") String username, @Query("password") String password, Callback<User> userCallback);

}