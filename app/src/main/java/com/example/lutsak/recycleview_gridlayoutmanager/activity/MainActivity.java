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
    private static final String LAYOUT_MANAGER = "Layout Manager";
    private static final String LINEAR_LAYOUT_MANAGER = "Linear Layout Manager";
    private static final String GRID_LAYOUT_MANAGER = "Grid Layout Manager";
    private static final String STAGGERED_GRID_LAYOUT_MANAGER = "Staggered Grid Layout Manager";


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
                intent.putExtra(LAYOUT_MANAGER, LINEAR_LAYOUT_MANAGER);
                break;
            case R.id.grid_layout_button:
                intent.putExtra(LAYOUT_MANAGER, GRID_LAYOUT_MANAGER);
                break;
            case R.id.staggered_grid_layout_button:
                intent.putExtra(LAYOUT_MANAGER, STAGGERED_GRID_LAYOUT_MANAGER);
                break;
            default:break;
        }
        startActivity(intent);
    }

    private void findView(){

        Button mLinearLayoutButton = findViewById(R.id.linear_layout_manager_button);
        Button mGridLayoutManager = findViewById(R.id.grid_layout_button);
        Button mStaggeredGridLayout = findViewById(R.id.staggered_grid_layout_button);

        mLinearLayoutButton.setOnClickListener(this);
        mGridLayoutManager.setOnClickListener(this);
        mStaggeredGridLayout.setOnClickListener(this);
    }
}
