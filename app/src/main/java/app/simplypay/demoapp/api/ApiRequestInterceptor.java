package app.simplypay.demoapp.api;

import app.simplypay.demoapp.utils.PrefManager;
import retrofit.RequestInterceptor;

/**
 * Created by jagadeeshakn on 3/16/2016.
 */
public class ApiRequestInterceptor implements RequestInterceptor {
    public static final String HEADER_TENANT = "X-Mifos-Platform-TenantId";
    public static final String HEADER_AUTH = "Authorization";

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader(HEADER_TENANT, PrefManager.getTenant());

        if (PrefManager.isAuthenticated())
            request.addHeader(HEADER_AUTH, PrefManager.getToken());
    }
}
