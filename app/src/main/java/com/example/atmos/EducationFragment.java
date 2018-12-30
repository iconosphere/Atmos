package com.example.atmos;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {


    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.content_education, container, false);

        Button diffuser_button = rootView.findViewById(R.id.button_education_diffuser);
        diffuser_button.setOnClickListener(view -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new ViewPagerEducationDiffuser()).commit();
        });

        return rootView;
    }

}
