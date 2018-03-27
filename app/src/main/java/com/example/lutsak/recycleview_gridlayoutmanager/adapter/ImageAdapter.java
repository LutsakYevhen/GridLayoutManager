package com.example.lutsak.recycleview_gridlayoutmanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.example.lutsak.recycleview_gridlayoutmanager.constant.Constant;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private static final String TAG = ImageAdapter.class.getSimpleName();

    private ArrayList<String> images;
    private Activity context;

    public ImageAdapter(Activity context, ArrayList<String> images){
        this.context = context;
        this.images = images;
    }


    /* This method return ViewHolder with parameter view, got using LayoutInflater */
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.image_container, parent, false);
        return new ViewHolder(view);
    }

    /*
     * This method use Picasso library, his work is to take an image from web source and set to
     * our ImageView.
     */
    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindingViewHolder : " + position);

        Picasso.with(context)
                .load(images.get(position))
                //TODO: why ic_loading is in mipmap and not in drawable?
                .placeholder(R.mipmap.ic_loading)
                .resize(Constant.SCREEN_WIDTH / 2,
                        Constant.SCREEN_WIDTH / 2)
                .into((holder.images));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    // todo: private static?
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView images;

        ViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.image_view_container);
        }
    }
}
