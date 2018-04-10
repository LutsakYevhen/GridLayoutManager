package com.example.lutsak.recycleview_gridlayoutmanager.adapter;

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

    private static final String TAG = StaggeredGridAdapter.class.getSimpleName();
    private static final int RANDOM_BOUND = 4;
    private static final int HEIGHT_MULTIPLIER = 300;

    private ArrayList<String> mImages;

    public StaggeredGridAdapter(ArrayList<String> images){
        this.mImages = images;
    }

    /* This method return ViewHolder with parameter view, got using LayoutInflater */
    @Override
    public StaggeredGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_container, parent, false);
        return new ViewHolder(view);
    }

    /*
     * This method use Picasso library, his work is to take an mImage from web source and set to
     * our ImageView.
     */
    @Override
    public void onBindViewHolder(StaggeredGridAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindingViewHolder width : " + holder.mImage.getLayoutParams().width);
        Log.d(TAG, "onBindingViewHolder high : " + holder.mImage.getLayoutParams().height);

        Picasso.with(holder.mImage.getContext())
                .load(mImages.get(position))
                .placeholder(R.drawable.loading)
                .into((holder.mImage));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private Random mRandomHeight = new Random();

        ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_view_container);

            int height = mRandomHeight.nextInt(RANDOM_BOUND);
            if (height == 0){
                height++;
                height = height * HEIGHT_MULTIPLIER;
            } else {
                height = height * HEIGHT_MULTIPLIER;
            }
            mImage.getLayoutParams().height = height;
            Log.d(TAG, " ViewHolder width : " + mImage.getLayoutParams().width);
            Log.d(TAG, " ViewHolder height : " + mImage.getLayoutParams().height);
        }
    }
}
