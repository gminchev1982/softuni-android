package com.example.gminchev.notification.ul;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private Context context;
    private FamilyFragment mFamily = new FamilyFragment();
    private VolunteerFragment mVolunteer = new VolunteerFragment();
    private boolean mIsFamily = false;
    private boolean mIsVolunteer = false;

    private int mCount = 0;

    public PageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (mIsFamily && mCount >= 1) return mFamily;
                if (!mIsFamily && mIsVolunteer && mCount == 1) return mVolunteer;

            case 1:
                return mVolunteer;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCountOfPage(boolean isFamily, boolean isVolunteer) {
        mIsFamily = isFamily;
        mIsVolunteer = isVolunteer;
        mCount = 1;
        if (mIsFamily && mIsVolunteer) mCount = 2;
    }


}
