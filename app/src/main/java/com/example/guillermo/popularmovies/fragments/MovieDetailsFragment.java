package com.example.guillermo.popularmovies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guillermo.popularmovies.model.MovieItem;

/**
 * Created by guillermo on 17/09/16.
 */
public class MovieDetailsFragment extends Fragment {

    private final String LOG_TAG=MovieDetailsFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        MovieItem item = (MovieItem) getActivity().getIntent().getSerializableExtra(MovieItem.class.getSimpleName());
        Log.v(LOG_TAG,item.getTitle());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
