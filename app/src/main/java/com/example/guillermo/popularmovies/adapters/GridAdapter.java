package com.example.guillermo.popularmovies.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.guillermo.popularmovies.R;
import com.example.guillermo.popularmovies.model.MovieItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by guillermo on 11/09/16.
 */
public class GridAdapter extends ArrayAdapter<MovieItem> {

    private Context context;

    public GridAdapter(Context context, int resource, List<MovieItem> objects) {
        super(context, resource, objects);
        this.context = context;
    }
    private class ViewHolder {
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        MovieItem movieItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_grid_fragment, null);
            holder = new ViewHolder();
            holder.imageView = new ImageView(context);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        Picasso.with(context).load(movieItem.getThumbUri()).noFade().into(holder.imageView);

        return convertView;
    }
}
