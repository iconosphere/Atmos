package com.example.atmos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EducationSustainability extends Fragment {


    public EducationSustainability() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_education_sustainability, container, false);

        Button sustainableAlternatives = rootView.findViewById(R.id.sustainable_alternatives);
        sustainableAlternatives.setOnClickListener(view -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new SustainabilityPage1()).addToBackStack(null).commit();
        });

        return rootView;
    }

}
