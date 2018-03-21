package com.example.lutsak.recycleview_gridlayoutmanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<String> images;
    private Activity context;
    private View view;
    private ViewHolder myHolder;
    private int screenWidth;
    private ViewHolder dataObjectHolder;

    public ImageAdapter(Activity context, ArrayList<String> images){
        this.context = context;
        this.images = images;

            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;

    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        dataObjectHolder = new ViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
        myHolder = holder;

        Picasso.with(context)
                .load(images.get(position))
                .placeholder(R.drawable.dbs)
                .resize(screenWidth / 2, screenWidth / 2)
                .centerCrop()
                .into((myHolder.images));

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView images;

        public ViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.img_view_row);
        }
    }
}
