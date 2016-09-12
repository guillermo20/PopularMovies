package com.example.guillermo.popularmovies.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.guillermo.popularmovies.R;
import com.example.guillermo.popularmovies.adapters.GridAdapter;
import com.example.guillermo.popularmovies.backgroundtasks.FetchPopularMoviesTask;
import com.example.guillermo.popularmovies.model.MovieItem;

import java.util.ArrayList;

/**
 * Created by guillermo on 11/09/16.
 */
public class MainGridFragment extends Fragment {

    private final String LOG_TAG = MainGridFragment.class.getSimpleName();

    /*private List<String> popularMoviesList;
    private List<String> mostRatedMoviesList;
    */
    private FetchPopularMoviesTask backgroundTask;
    private ArrayAdapter<MovieItem> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        adapter = new GridAdapter(getActivity(),R.layout.main_grid_fragment,new ArrayList<MovieItem>());

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (backgroundTask == null) {
            backgroundTask = new FetchPopularMoviesTask(adapter);
        }
        backgroundTask.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(LOG_TAG, "maingrid oncreateview");
        View root = inflater.inflate(R.layout.main_grid_fragment, container, false);
        GridView gridView = (GridView) root.findViewById(R.id.main_grid_fragment_id);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(LOG_TAG,"STarts the detail activity");
            }
        });
        /*if (backgroundTask.getListMovieItem() != null) {
            for (MovieItem item : backgroundTask.getListMovieItem()) {
                Log.v(LOG_TAG, "Item =" + item.getTitle());
            }
        }*/
        //GridAdapter adapter = new GridAdapter(getActivity(),backgroundTask.getListMovieItem());

        return root;
    }

}
