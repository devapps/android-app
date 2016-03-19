package app.simplypay.demoapp.simplypay.core.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import app.simplypay.demoapp.R;
import app.simplypay.demoapp.simplypay.core.fragment.PaymentMenuFragment;
import app.simplypay.demoapp.utils.Constants;

/**
 * Created by jagadeeshakn on 3/18/2016.
 */
public class PaymentHomePage extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_container);
        startFragment();
    }
    public void startFragment(){
        PaymentMenuFragment paymentMenuFragment =new PaymentMenuFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.global_container,paymentMenuFragment, Constants.PAYMENT_MENU_FRAGMENT);
        fragmentTransaction.commit();

    }

}
