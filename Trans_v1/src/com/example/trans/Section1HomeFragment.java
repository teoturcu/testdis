package com.example.trans;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Section1HomeFragment extends Fragment {
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	System.out.println("===00===");

    	View rootView = inflater.inflate(R.layout.fragment_section1_home, container, false);
    	return rootView;
    }
}