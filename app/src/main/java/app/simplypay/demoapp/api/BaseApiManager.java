package app.simplypay.demoapp.api;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import app.simplypay.demoapp.api.services.AuthService;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by jagadeeshakn on 3/16/2016.
 */
public class BaseApiManager {
    private ApiEndPoint API_ENDPOINT = new ApiEndPoint();

    private AuthService authApi;
    public BaseApiManager()
    {
        createAuthApi(false);
    }


    public void setupEndpoint(String instanceUrl, String tenantIdentifier) {
        API_ENDPOINT.updateInstanceUrl(instanceUrl, tenantIdentifier);
    }

    private <T> T createApi(Class<T> clazz, Endpoint endpoint) {
        RestAdapter.Builder restAdapterBuilder = new RestAdapter.Builder();
        restAdapterBuilder.setClient(new OkClient(getUnsafeOkHttpClient()));
        return restAdapterBuilder
                .setEndpoint(endpoint)
                .setRequestInterceptor(new ApiRequestInterceptor())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .build()
                .create(clazz);
    }

    private void createAuthApi(boolean shouldByPassSSLSecurity) {
        RestAdapter.Builder restAdapterBuilder = new RestAdapter.Builder();
        if (shouldByPassSSLSecurity) {
            restAdapterBuilder.setClient(new OkClient(getUnsafeOkHttpClient()));
        }
        authApi = restAdapterBuilder
                .setEndpoint(API_ENDPOINT)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .setRequestInterceptor(new ApiRequestInterceptor())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(AuthService.class);
    }


    private OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setSslSocketFactory(sslSocketFactory);
            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    protected AuthService getAuthApi(boolean shouldByPassSSLSecurity) {
        createAuthApi(shouldByPassSSLSecurity);
        return authApi;
    }
}
