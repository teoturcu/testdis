package com.example.trans;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Section5ContactFragment extends Fragment {
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	System.out.println("===04===");

    	View rootView = inflater.inflate(R.layout.fragment_section5_contact, container, false);
    	return rootView;
    }
}