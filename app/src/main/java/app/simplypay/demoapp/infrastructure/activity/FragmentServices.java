package app.simplypay.demoapp.infrastructure.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import app.simplypay.demoapp.R;

/**
 * Created by jagadeeshakn on 3/18/2016.
 */
public class FragmentServices {

    public static boolean checkFragmentBackStack(FragmentManager fragmentManager,String TAG)
    {
        if(fragmentManager.getBackStackEntryCount()!=0)
            return true;

        else
            return false;
    }
    public static void startFragmentWithoutBackStack(FragmentManager fragmentManager,int containerId,Fragment fragment,String TAG)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment, TAG);
        fragmentTransaction.commit();
    }
    public static void startFragmentWithBackStack(FragmentManager fragmentManager,int containerId,Fragment fragment,String presentFragmentName,String newFragmentName)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(newFragmentName);
        fragmentTransaction.replace(containerId, fragment, newFragmentName).commit();
    }

    public static void startFragmentPresentInBackStack(FragmentManager fragmentManager,Fragment fragment,String TAG)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, TAG);
        fragmentTransaction.commit();
    }
}

