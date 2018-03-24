package com.example.lutsak.recycleview_gridlayoutmanager.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.example.lutsak.recycleview_gridlayoutmanager.constant.Constant;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<String> images;
    private Activity context;
    private final Constant constant = new Constant();

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
        Log.d(Constant.LOG_TAG, "onBindingViewHolder : " + position);

        Picasso.with(context).load(images.get(position)).placeholder(R.mipmap.ic_loading)
                .resize(Constant.SCREEN_WIDTH / constant.getSpanCount(),
                        Constant.SCREEN_WIDTH / constant.getSpanCount())
                .into((holder.images));
    }


    @Override
    public int getItemCount() {
        return images.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView images;

        ViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.image_view_container);
        }
    }
}
