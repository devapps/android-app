package app.simplypay.demoapp.simplypay.core.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.simplypay.demoapp.R;
import butterknife.ButterKnife;

/**
 * Created by jagadeeshakn on 3/18/2016.
 */
public class PaymentMenuFragment extends Fragment {

    View rootView;
    ActionBarActivity activity;
    android.support.v7.app.ActionBar actionBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.payment_home_screen_fragment,container,false);
        activity=(ActionBarActivity)getActivity();
        ButterKnife.inject(this,rootView);
        if (isAdded()){


        }
        actionBar=activity.getSupportActionBar();
        actionBar.setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_HOME_AS_UP | android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher);
        actionBar.setSubtitle(R.string.title_home_fragmnet);

        return rootView;
    }


}


