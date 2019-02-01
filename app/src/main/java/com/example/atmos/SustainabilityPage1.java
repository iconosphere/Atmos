package com.example.atmos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SustainabilityPage1 extends Fragment {


    public SustainabilityPage1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sustainability_page1, container, false);

        TextView alternativeText = rootView.findViewById(R.id.sustainability_spinner_alternative_eo);
        TextView alternativeTextLong = rootView.findViewById(R.id.sustainability_spinner_long_text);


        Spinner sustainabilitySpinner = rootView.findViewById(R.id.fragment_spinner);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.blends_spinner, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sustainabilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int count = 0;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (count >= 1){
                    switch (position) {
                        case 0:
                            alternativeText.setText(R.string.spinner_alternative1);
                            alternativeTextLong.setText(R.string.spinner_alternative1_long);
                            break;
                        case 1:
                            alternativeText.setText(R.string.spinner_alternative1);
                            alternativeTextLong.setText(R.string.spinner_alternative1_long);
                            break;
                    }
                }
                count++;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sustainabilitySpinner.setAdapter(spinnerAdapter);

        return rootView;
    }

}
