package com.example.lutsak.recycleview_gridlayoutmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.lutsak.recycleview_gridlayoutmanager.R;
import com.example.lutsak.recycleview_gridlayoutmanager.reciclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, ">> onCreate");

        findView();

        Log.v(TAG, "<< onCreate");
    }

    @Override
    public void onClick(View v) {
        
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        
        switch (v.getId()){
            case R.id.linear_layout_manager_button:
                RecyclerViewActivity.fillStartIntent(intent,
                        RecyclerViewActivity.LayoutManager.LINEAR_LAYOUT_MANAGER);
                break;
            case R.id.grid_layout_button:
                RecyclerViewActivity.fillStartIntent(intent,
                        RecyclerViewActivity.LayoutManager.GRID_LAYOUT_MANAGER);
                break;
            case R.id.staggered_grid_layout_button:
                RecyclerViewActivity.fillStartIntent(intent,
                        RecyclerViewActivity.LayoutManager.STAGGERED_GRID_LAYOUT_MANAGER);
                break;
        }
        startActivity(intent);
    }

    private void findView(){

        Button linearLayoutButton = findViewById(R.id.linear_layout_manager_button);
        View gridLayoutManager = findViewById(R.id.grid_layout_button);
        Button staggeredGridLayout = findViewById(R.id.staggered_grid_layout_button);

        linearLayoutButton.setOnClickListener(this);
        gridLayoutManager.setOnClickListener(this);
        staggeredGridLayout.setOnClickListener(this);
    }
}
