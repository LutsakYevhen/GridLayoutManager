package com.example.lutsak.recycleview_gridlayoutmanager.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Random;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder> {

    private static final String TAG = GridAdapter.class.getSimpleName();

    private ArrayList<String> mImages;
    private Activity mContext;
    private static final int RANDOM_BOUND = 4;
    private static final int HEIGHT_MULTIPLIER = 300;

    public StaggeredGridAdapter(Activity context, ArrayList<String> images){
        this.mContext = context;
        this.mImages = images;
    }

    /* This method return ViewHolder with parameter view, got using LayoutInflater */
    @Override
    public StaggeredGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.image_container, parent, false);
        return new ViewHolder(view);
    }

    /*
     * This method use Picasso library, his work is to take an image from web source and set to
     * our ImageView.
     */
    @Override
    public void onBindViewHolder(StaggeredGridAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindingViewHolder width : " + holder.image.getLayoutParams().width);
        Log.d(TAG, "onBindingViewHolder high : " + holder.image.getLayoutParams().height);

        Picasso.with(mContext)
                .load(mImages.get(position))
                .placeholder(R.drawable.loading)
                .into((holder.image));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        Random randomHeight = new Random();

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view_container);

            int height = randomHeight.nextInt(RANDOM_BOUND);
            if (height == 0){
                height++;
                height = height * HEIGHT_MULTIPLIER;
            } else {
                height = height * HEIGHT_MULTIPLIER;
            }
            image.getLayoutParams().height = height;
            Log.d(TAG, " ViewHolder width : " + image.getLayoutParams().width);
            Log.d(TAG, " ViewHolder height : " + image.getLayoutParams().height);
        }
    }
}
