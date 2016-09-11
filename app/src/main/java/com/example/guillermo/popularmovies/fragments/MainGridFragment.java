package com.example.guillermo.popularmovies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guillermo.popularmovies.R;

import java.util.List;

/**
 * Created by guillermo on 11/09/16.
 */
public class MainGridFragment extends Fragment{

    private final String LOG_TAG = MainGridFragment.class.getSimpleName();

    private List<String> popularMoviesList;
    private List<String> mostRatedMoviesList;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(LOG_TAG,"maingrid oncreateview");
        View root = inflater.inflate(R.layout.main_grid_fragment, container,false);
        return root;
    }

    private List<String> getPopularMoviesData(){
        return null;
    }

    private List<String> getTopRatedMoviesData(){
        return null;
    }

}
