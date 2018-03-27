package com.example.lutsak.recycleview_gridlayoutmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lutsak.recycleview_gridlayoutmanager.reciclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, ">> onCreate");
        // TODO: add another two button with other two LayoutManager.


        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
        Log.v(TAG, "<< onCreate");
    }
}
