package com.example.trans;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Section2TraseeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	System.out.println("===00===");

    	View rootView = inflater.inflate(R.layout.fragment_main, container, false);
    	return rootView;
    }
}
