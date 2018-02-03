package com.example.anil.smarthelpline.login_tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.anil.smarthelpline.first_aid_Fragment;
import com.example.anil.smarthelpline.login_tabs.Home_Fragment;

/**
 * Created by anil on 15-01-2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                 Home_Fragment home_fragment = new Home_Fragment();
                return home_fragment;
            case 1:
                first_aid_Fragment first_aid_fragment = new first_aid_Fragment();
                return first_aid_fragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
