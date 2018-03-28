package com.example.lutsak.recycleview_gridlayoutmanager.reciclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.example.lutsak.recycleview_gridlayoutmanager.adapter.GridAdapter;
import com.example.lutsak.recycleview_gridlayoutmanager.adapter.LinearAdapter;
import com.example.lutsak.recycleview_gridlayoutmanager.adapter.StaggeredGridAdapter;
import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = RecyclerViewActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private final ArrayList<String> mImages = new ArrayList<>();
    private static final int SPAN_COUNT = 2;
    private static final int ORIENTATION = 1;
    private static final String LAYOUT_MANAGER = "Layout Manager";
    private static final String LINEAR_LAYOUT_MANAGER = "Linear Layout Manager";
    private static final String GRID_LAYOUT_MANAGER = "Grid Layout Manager";
    private static final String STAGGERED_GRID_LAYOUT_MANAGER = "Staggered Grid Layout Manager";
    private static final String[] IMAGES = new String[]{
            "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg",
            "https://lh4.googleusercontent.com/--dq8niRp7W4/URquVgmXvgI/AAAAAAAAAbs/-gnuLQfNnBA/s1024/A%252520Song%252520of%252520Ice%252520and%252520Fire.jpg",
            "https://lh5.googleusercontent.com/-7qZeDtRKFKc/URquWZT1gOI/AAAAAAAAAbs/hqWgteyNXsg/s1024/Another%252520Rockaway%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/--L0Km39l5J8/URquXHGcdNI/AAAAAAAAAbs/3ZrSJNrSomQ/s1024/Antelope%252520Butte.jpg",
            "https://lh6.googleusercontent.com/-8HO-4vIFnlw/URquZnsFgtI/AAAAAAAAAbs/WT8jViTF7vw/s1024/Antelope%252520Hallway.jpg",
            "https://lh4.googleusercontent.com/-WIuWgVcU3Qw/URqubRVcj4I/AAAAAAAAAbs/YvbwgGjwdIQ/s1024/Antelope%252520Walls.jpg",
            "https://lh6.googleusercontent.com/-UBmLbPELvoQ/URqucCdv0kI/AAAAAAAAAbs/IdNhr2VQoQs/s1024/Apre%2525CC%252580s%252520la%252520Pluie.jpg",
            "https://lh3.googleusercontent.com/-s-AFpvgSeew/URquc6dF-JI/AAAAAAAAAbs/Mt3xNGRUd68/s1024/Backlit%252520Cloud.jpg",
            "https://lh5.googleusercontent.com/-bvmif9a9YOQ/URquea3heHI/AAAAAAAAAbs/rcr6wyeQtAo/s1024/Bee%252520and%252520Flower.jpg",
            "https://lh5.googleusercontent.com/-n7mdm7I7FGs/URqueT_BT-I/AAAAAAAAAbs/9MYmXlmpSAo/s1024/Bonzai%252520Rock%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-4CN4X4t0M1k/URqufPozWzI/AAAAAAAAAbs/8wK41lg1KPs/s1024/Caterpillar.jpg",
            "https://lh3.googleusercontent.com/-rrFnVC8xQEg/URqufdrLBaI/AAAAAAAAAbs/s69WYy_fl1E/s1024/Chess.jpg",
            "https://lh5.googleusercontent.com/-WVpRptWH8Yw/URqugh-QmDI/AAAAAAAAAbs/E-MgBgtlUWU/s1024/Chihuly.jpg",
            "https://lh5.googleusercontent.com/-0BDXkYmckbo/URquhKFW84I/AAAAAAAAAbs/ogQtHCTk2JQ/s1024/Closed%252520Door.jpg",
            "https://lh3.googleusercontent.com/-PyggXXZRykM/URquh-kVvoI/AAAAAAAAAbs/hFtDwhtrHHQ/s1024/Colorado%252520River%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/-ZAs4dNZtALc/URquikvOCWI/AAAAAAAAAbs/DXz4h3dll1Y/s1024/Colors%252520of%252520Autumn.jpg",
            "https://lh4.googleusercontent.com/-GztnWEIiMz8/URqukVCU7bI/AAAAAAAAAbs/jo2Hjv6MZ6M/s1024/Countryside.jpg",
            "https://lh4.googleusercontent.com/-bEg9EZ9QoiM/URquklz3FGI/AAAAAAAAAbs/UUuv8Ac2BaE/s1024/Death%252520Valley%252520-%252520Dunes.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        Log.d(TAG, ">> RecyclerViewActivity");
        mRecyclerView = findViewById(R.id.recycler_view);

        initializeImages();
        defineLayoutManager();
        defineAdapter();

        Log.d(TAG, "<< RecyclerViewActivity");
    }

    //Randomly initialize wide array using our unique (url)image.
    private void initializeImages() {
        int NUMBER_OF_IMG_MULTIPLICATION = 500;
        Random random = new Random(IMAGES.length);

        for (int i = 0; i < IMAGES.length * NUMBER_OF_IMG_MULTIPLICATION; i++) {
            mImages.add(IMAGES[random.nextInt(IMAGES.length)]);
        }
    }

    private void setLinearLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void setGridLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void setStaggeredGridLayoutManager() {
        RecyclerView.LayoutManager layoutManager =
                new StaggeredGridLayoutManager(SPAN_COUNT, ORIENTATION);

        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void setLinearAdapter() {
        RecyclerView.Adapter adapter = new LinearAdapter(this, mImages);
        mRecyclerView.setAdapter(adapter);
    }

    private void setGridAdapter() {
        RecyclerView.Adapter adapter = new GridAdapter(this, mImages);
        mRecyclerView.setAdapter(adapter);
    }

    private void setStaggeredGridAdapter() {
        RecyclerView.Adapter adapter = new StaggeredGridAdapter(this, mImages);
        mRecyclerView.setAdapter(adapter);
    }

    private void defineLayoutManager(){
        Intent intent = getIntent();
        switch (intent.getStringExtra(LAYOUT_MANAGER)){
            case LINEAR_LAYOUT_MANAGER:
                setLinearLayoutManager();
                break;
            case GRID_LAYOUT_MANAGER:
                setGridLayoutManager();
                break;
            case STAGGERED_GRID_LAYOUT_MANAGER:
                setStaggeredGridLayoutManager();
                break;
            default:break;
        }
    }

    private void defineAdapter(){
        Intent intent = getIntent();
        switch (intent.getStringExtra(LAYOUT_MANAGER)){
            case LINEAR_LAYOUT_MANAGER:
                setLinearAdapter();
                break;
            case GRID_LAYOUT_MANAGER:
                setGridAdapter();
                break;
            case STAGGERED_GRID_LAYOUT_MANAGER:
                setStaggeredGridAdapter();
                break;
            default:break;
        }
    }
}
