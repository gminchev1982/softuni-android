package com.example.gminchev.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


class TimelinePagerAdapter  extends FragmentPagerAdapter {

    private  Context context;

    public TimelinePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OverallFragment();
            case 1:
                return new DetailFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return context.getString(R.string.overall);
            case 1:
                return context.getString(R.string.details);
            default:
                return null;
        }
    }
}
