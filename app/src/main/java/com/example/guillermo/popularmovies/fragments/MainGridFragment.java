package com.example.guillermo.popularmovies.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.example.guillermo.popularmovies.R;
import com.example.guillermo.popularmovies.adapters.GridAdapter;
import com.example.guillermo.popularmovies.backgroundtasks.FetchPopularMoviesTask;
import com.example.guillermo.popularmovies.model.MovieItem;

import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayAdapter<String> sortingAdapter;
    private String options[] = {"Most Popular","Most Rated"};

    @Override
    public void onCreate(Bundle savedInstanceState) {


        adapter = new GridAdapter(getActivity(),R.layout.main_grid_fragment,new ArrayList<MovieItem>());
        sortingAdapter = new ArrayAdapter <String> (getActivity(),R.layout.spinner_item,R.id.spinner_texview_id, Arrays.asList(options));
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.main_menu_spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(menuItem);
        spinner.setAdapter(sortingAdapter);
        spinner.getPopupBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SCREEN);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v(LOG_TAG,"clicked on item from spinner");
                switch (position){
                    case 0:
                        
                        break;
                    case 1:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

}
