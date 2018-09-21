package com.example.gminchev.notification.ul;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.notification.R;
import com.example.gminchev.notification.databinding.FragmentFamilyBinding;

public class FamilyFragment extends Fragment {
    FragmentFamilyBinding binding;

    public FamilyFragment() {
        // Required empty public constructor
    }

    public static FamilyFragment newInstance() {
        FamilyFragment fragment = new FamilyFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_family, container, false);

        return binding.getRoot();
    }
}
