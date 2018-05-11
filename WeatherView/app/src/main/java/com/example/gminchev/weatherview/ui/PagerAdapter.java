package com.example.gminchev.weatherview.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gminchev.weatherview.ui.daily.DailyFragment;
import com.example.gminchev.weatherview.ui.forecast.DetailFragment;

public class PagerAdapter extends FragmentPagerAdapter implements OverallFragment.OnFragmentTitleListener{

    private Context context;
    private OverallFragment mOverall = new OverallFragment();
    private DetailFragment mDetail = new DetailFragment();
    private DailyFragment mDaily = new DailyFragment();

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

            case 2:
                return mDaily;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Overall";
            case 1:
                return "Detail";
            case 2:
                return "Daily";
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
