package com.example.guillermo.popularmovies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guillermo.popularmovies.R;

/**
 * Created by guillermo on 11/09/16.
 */
public class MainGridFragment extends Fragment{

    private final String LOG_TAG = MainGridFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(LOG_TAG,"maingrid oncreateview");
        View root = inflater.inflate(R.layout.main_grid_fragment, container,false);
        return root;
    }
}
