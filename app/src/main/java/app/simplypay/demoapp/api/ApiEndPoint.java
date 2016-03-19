package app.simplypay.demoapp.api;

import retrofit.Endpoint;

/**
 * Created by jagadeeshakn on 3/16/2016.
 */
public class ApiEndPoint implements Endpoint {

    public static final String API_ENDPOINT = "192.168.0.110";
    public static final String API_PATH = "/fineract/api/v1";
    public static final String PROTOCOL_HTTPS = "https://";

    private String url;
    private String tenantIdentifier;

    public void updateInstanceUrl(String instanceUrl,String tenantIdentifier) {
        this.url = instanceUrl;
        this.tenantIdentifier=tenantIdentifier;
    }

    @Override
    public String getUrl() {
        if (url == null)
            return PROTOCOL_HTTPS + API_ENDPOINT + API_PATH;
        return url;
    }

    @Override
    public String getName() {
        return "simply pay";
    }
}
