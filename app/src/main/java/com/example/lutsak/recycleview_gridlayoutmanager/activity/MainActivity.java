package com.example.lutsak.recycleview_gridlayoutmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.lutsak.recycleview_gridlayoutmanager.reciclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: add another two button with other two LayoutManager.

        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
