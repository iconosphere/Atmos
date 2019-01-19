package com.example.atmos.dummy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BlendViewModel extends AndroidViewModel {

    private BlendRepository mRepository;
    private LiveData<List<Blend>> mAllBlends;

    public BlendViewModel(@NonNull Application application) {
        super(application);
        mRepository = new BlendRepository(application);
        mAllBlends = mRepository.getAllBlends();
    }

    public LiveData<List<Blend>> getAllBlends() {
        return mAllBlends;
    }

}
