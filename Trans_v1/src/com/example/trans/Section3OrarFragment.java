package com.example.trans;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Section3OrarFragment extends Fragment {
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	System.out.println("===02===");

    	View rootView = inflater.inflate(R.layout.fragment_section3_orar, container, false);
    	return rootView;
    }
}