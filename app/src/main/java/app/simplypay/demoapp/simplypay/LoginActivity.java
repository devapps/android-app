package app.simplypay.demoapp.simplypay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import org.apache.http.HttpStatus;

import javax.net.ssl.SSLHandshakeException;

import app.simplypay.demoapp.App;
import app.simplypay.demoapp.R;
import app.simplypay.demoapp.objects.User;
import app.simplypay.demoapp.simplypay.core.SimplyPayBaseActivity;
import app.simplypay.demoapp.utils.PrefManager;
import app.simplypay.demoapp.utils.Toaster;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jagadeeshakn on 3/17/2016.
 */
public class LoginActivity extends SimplyPayBaseActivity implements Callback<User> {


    private String username;
    private String instanceURL;
    private String tenantIdentifier;
    private String password;
    private boolean isValidUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void success(User user, Response response) {
        hideProgress();
        PrefManager.setUserId(user.getUserId());
        // Saving InstanceURL for next usages
        PrefManager.setInstanceUrl("instanceURL");
        // Saving domain name
        PrefManager.setInstanceDomain("simplypay");
        // Saving port
        PrefManager.setPort("80");
        // Saving tenant
        PrefManager.setTenant("default");
        // Saving user's token
        PrefManager.saveToken("Basic " + user.getBase64EncodedAuthenticationKey());

        startActivity(new Intent());
        finish();


    }

    @Override
    public void failure(RetrofitError retrofitError) {
        try {
            hideProgress();

            if (retrofitError.getCause() instanceof SSLHandshakeException) {
                promptUserToByPassTheSSLHandshake();
            } else if (retrofitError.getResponse().getStatus() ==  HttpStatus.SC_UNAUTHORIZED) {
                Toaster.show(findViewById(android.R.id.content), getString(R.string.error_login_failed));
            } else if (retrofitError.getResponse().getStatus() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                Toaster.show(findViewById(android.R.id.content), "Internal server error");
            }
        } catch (NullPointerException e) {
            Toaster.show(findViewById(android.R.id.content), getString(R.string.error_unknown));
        }

    }
    private void promptUserToByPassTheSSLHandshake() {
        new AlertDialog.Builder(this)
                .setTitle("SSL Certificate Problem")
                .setMessage("There is a problem with your SSLCertificate, would you like to continue? This connection would be unsafe.")
                .setIcon(android.R.drawable.stat_sys_warning)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        login(true);
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create().show();
    }
    private void login(boolean shouldByPassSSLSecurity) {
        showProgress("Logging In");
        App.apiManager.setupEndpoint(instanceURL,tenantIdentifier);
        App.apiManager.login(username, password, shouldByPassSSLSecurity, this);
    }

}
