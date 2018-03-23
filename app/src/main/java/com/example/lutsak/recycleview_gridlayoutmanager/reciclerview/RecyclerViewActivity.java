package com.example.lutsak.recycleview_gridlayoutmanager.reciclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.example.lutsak.recycleview_gridlayoutmanager.adapter.ImageAdapter;
import com.example.lutsak.recycleview_gridlayoutmanager.constant.Constant;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMain;
    private ArrayList<String> images;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter adapter;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.my_recycler_view);
        initializeImages();
        setGridLayoutManager();
        setAdapter();
    }

    private void initializeImages() {
        random = new Random(Constant.IMAGES.length);
        images = new ArrayList<>();
        for (int i = 0; i < Constant.IMAGES.length * Constant.NUMBER_OF_IMG_MULTIPLICATION; i++) {
            images.add(Constant.IMAGES[random.nextInt(Constant.IMAGES.length)]);
        }
    }

    private void setGridLayoutManager() {
        mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewMain.setLayoutManager(mLayoutManager);
    }

    private void setAdapter() {
        adapter = new ImageAdapter(this, images);
        recyclerViewMain.setAdapter(adapter);
    }
}
