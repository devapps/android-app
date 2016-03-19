package app.simplypay.demoapp.simplypay.core.util;

/**
 * Created by jagadeeshakn on 3/17/2016.
 */
public interface BaseActivityCallback {
    void showProgress(String message);

    void setToolbarTitle(String title);

    void hideProgress();

    void logout();
}