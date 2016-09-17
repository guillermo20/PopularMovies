package com.example.guillermo.popularmovies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guillermo.popularmovies.R;
import com.example.guillermo.popularmovies.model.MovieItem;

/**
 * Created by guillermo on 17/09/16.
 */
public class MovieDetailsFragment extends Fragment {

    private final String LOG_TAG=MovieDetailsFragment.class.getSimpleName();

    private MovieItem movieItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        movieItem = (MovieItem) getActivity().getIntent().getSerializableExtra(MovieItem.class.getSimpleName());
        Log.v(LOG_TAG,movieItem.getTitle());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_details_fragment,container,false);
        TextView textViewTitle = (TextView) rootView.findViewById(R.id.movie_details_title);
        textViewTitle.setText(movieItem.getTitle());
        return rootView;
    }
}