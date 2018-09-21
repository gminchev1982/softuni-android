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
import com.example.gminchev.notification.databinding.FragmentVolunteerBinding;

public class VolunteerFragment extends Fragment {
    FragmentVolunteerBinding binding;

    public VolunteerFragment() {
        // Required empty public constructor
    }

    public static VolunteerFragment newInstance() {
        VolunteerFragment fragment = new VolunteerFragment();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_volunteer, container, false);

        return binding.getRoot();
    }
}
