package app.simplypay.demoapp.utils;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import app.simplypay.demoapp.App;

/**
 * Created by jagadeeshakn on 3/17/2016.
 */
public class Toaster {

    public static void show(View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public static void show(View view, int res) {
        show(view, App.getContext().getResources().getString(res));
    }
}
