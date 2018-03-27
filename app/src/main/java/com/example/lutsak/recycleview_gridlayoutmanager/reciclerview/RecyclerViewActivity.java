package com.example.lutsak.recycleview_gridlayoutmanager.reciclerview;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.example.lutsak.recycleview_gridlayoutmanager.adapter.ImageAdapter;
import com.example.lutsak.recycleview_gridlayoutmanager.constant.Constant;
import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    //TODO: use naming convention
    private RecyclerView recyclerView;
    private final ArrayList<String> images = new ArrayList<>();
    private final Constant constant = new Constant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Constant.LOG_TAG, "Creating RecyclerViewActivity");

        recyclerView = findViewById(R.id.recycler_view);
        initializeImages();
        setGridLayoutManager();
        setAdapter();

        Log.d(Constant.LOG_TAG, "RecyclerViewActivity created.");
    }

    //Randomly initialize wide array using our unique (url)image.
    private void initializeImages() {
        Random random = new Random(constant.getImagesUrl().length);

        for (int i = 0; i < constant.getImagesUrl().length * constant.getNumberOfItemMultiplication(); i++) {
            images.add(constant.getImagesUrl()[random.nextInt(constant.getImagesUrl().length)]);
        }

        // TODO: remove and realize why do we need to remove it :)
        if (images.size() == constant.getImagesUrl().length * constant.getNumberOfItemMultiplication()) {
            Log.d(Constant.LOG_TAG, "All images initialized properly");
        } else {
            Log.d(Constant.LOG_TAG, "Something goes wrong with image initialization");
        }
    }

    private void setGridLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, constant.getSpanCount());
        recyclerView.setLayoutManager(layoutManager);

        // TODO: remove and realize why do we need to remove it :)
        if (recyclerView.getLayoutManager() == layoutManager){
            Log.d(Constant.LOG_TAG, "LayoutManager sett properly");
        } else {
            Log.d(Constant.LOG_TAG, "Something goes wrong setting LayoutManager");
        }
    }

    private void setAdapter() {
        RecyclerView.Adapter adapter = new ImageAdapter(this, images);
        recyclerView.setAdapter(adapter);

        // TODO: remove and realize why do we need to remove it :)
        if (recyclerView.getAdapter() == adapter){
            Log.d(Constant.LOG_TAG, "Adapter sett properly");
        } else {
            Log.d(Constant.LOG_TAG, "Something goes wrong setting Adapter");
        }
    }
}
