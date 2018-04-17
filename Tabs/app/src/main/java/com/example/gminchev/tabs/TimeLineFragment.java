package com.example.gminchev.tabs;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.tabs.databinding.FragmentTimelineBinding;

public class TimeLineFragment extends Fragment {

    FragmentTimelineBinding binding;
    private OnFragmentDataReceived listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_timeline, container, false);
        setupTabs();
        return binding.getRoot();
    }



    @Override
    public void onResume() {
        super.onResume();
        setupTabs();
    }

    public void setupTabs() {
        TimelinePagerAdapter adapter = new TimelinePagerAdapter(getContext(), getChildFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.grpTabs.setupWithViewPager(binding.viewpager);

    }

    public interface OnFragmentDataReceived {
        void onDataReceived(String text);
    }




}
