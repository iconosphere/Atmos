package com.example.atmos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CardViewFragment extends Fragment {

    private Boolean isExpanded = false;


    public CardViewFragment(){
        // Empty Fragment Constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment, container, false);

        ImageView show_more = rootView.findViewById(R.id.show_more);
        TextView textView = rootView.findViewById(R.id.textView);
        Button button = rootView.findViewById(R.id.button);
        textView.setVisibility(View.GONE);

        button.setOnClickListener(view -> {
            if (isExpanded) {
                show_more.animate().rotation(0).start();
                isExpanded = false;
                textView.setVisibility(View.GONE);
            }
            else {
                show_more.animate().rotation(180).start();
                isExpanded = true;
                textView.setVisibility(View.VISIBLE);
            }
        });


        return rootView;
    }
}
