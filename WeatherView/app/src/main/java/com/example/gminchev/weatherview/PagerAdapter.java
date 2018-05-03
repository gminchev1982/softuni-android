package com.example.gminchev.weatherview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter implements OverallFragment.OnFragmentTitleListener{

    private Context context;
    private OverallFragment mOverall = new OverallFragment();
    private DetailFragment mDetail = new DetailFragment();

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mOverall;
            case 1:
                return mDetail;
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
                return "Overall";
            case 1:
                return "Detail";
            default:
                return null;
        }
    }


    @Override
    public void onTitleChange(String title) {

    }

    @Override
    public void onViewPageChange(long date) {
        mDetail.onViewPageChange(date);
    }
}
