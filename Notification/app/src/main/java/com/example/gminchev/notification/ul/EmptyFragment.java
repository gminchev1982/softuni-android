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

public class EmptyFragment extends Fragment {
    FragmentFamilyBinding binding;

    public EmptyFragment() {
        // Required empty public constructor
    }

    public static EmptyFragment newInstance() {
        EmptyFragment fragment = new EmptyFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_family, container, false);

        return binding.getRoot();
    }
}
