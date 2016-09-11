package com.example.guillermo.popularmovies.backgroundtasks;

import android.os.AsyncTask;

/**
 * Created by guillermo on 11/09/16.
 */
public class FetchTopRatedMoviesTask extends AsyncTask<Void,Void,Void> {
    private final String TOP_RATED_MOVIES_URL = "http://api.themoviedb.org/3/movie/top_rated?api_key=c43913d1a49f497d8925f9a02c52e645";
    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }
}
