package com.example.atmos;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.atmos.Blend;
import com.example.atmos.R;

import java.util.ArrayList;

public class BlendFragment extends Fragment {

    public BlendFragment() {

    }

    // Member variables.
    private ArrayList<Blend> mBlendData;
    private RecyclerView mRecyclerView;
    private BlendRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.recyclerview, container, false);

        // Initialise the RecyclerView
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        // Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialise the ArrayList that will contain the data.
        mBlendData = new ArrayList<>();

        // Initialise the adapter and set it to the RecyclerView.
        mAdapter = new BlendRecyclerViewAdapter(getContext(), mBlendData);
        mRecyclerView.setAdapter(mAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        // Get the data.
        initializeData();

        return rootView;
    }

    private void initializeData() {
        // Get resources from XML file.
        String[] blendName = getResources().getStringArray(R.array.blend_names);
        String[] blendRecipe = getResources().getStringArray(R.array.blend_recipe);
        String[] blendFurtherInfo = getResources().getStringArray(R.array.blend_further_info);
        String[] blendDidYouKnow = getResources().getStringArray(R.array.blend_did_you_know);

        // Clear existing data to avoid duplication.
        mBlendData.clear();

        // Create ArrayList of Blend objects populated with Name, Recipe, Further Info and Did You Know
        for (int i = 0; i < blendName.length; i++) {
            mBlendData.add(new Blend(blendName[i], blendRecipe[i], blendFurtherInfo[i], blendDidYouKnow[i]));
        }

        // Notify adapter of the change.
        mAdapter.notifyDataSetChanged();


    }

}
