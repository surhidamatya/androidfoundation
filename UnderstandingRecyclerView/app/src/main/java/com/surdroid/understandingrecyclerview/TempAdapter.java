package com.surdroid.understandingrecyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by surhid on 4/2/17.
 */

public class TempAdapter extends RecyclerView.Adapter<TempAdapter.TempViewHolder> {


    @Override
    public TempViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TempViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TempViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivMoviePoster;
        public TextView tvMovieName;


        public TempViewHolder(View itemView) {
            super(itemView);

            ivMoviePoster = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
            tvMovieName = (TextView) itemView.findViewById(R.id.tv_movie_name);
        }
    }
}
