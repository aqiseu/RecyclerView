package com.android.intermed.recyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.intermed.recyclerview.R;
import com.android.intermed.recyclerview.adapter.ClassAdapter;
import com.android.intermed.recyclerview.model.ClassData;
import com.android.intermed.recyclerview.model.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClassAdapter.ItemClickCallback {
    private static final String bundle = "bundle";
    private static final String bundle1 = "bundle1";

    private RecyclerView recyclerView;
    private ClassAdapter adapter1;

    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = (ArrayList) ClassData.getListData();

        recyclerView = (RecyclerView) findViewById(R.id.rv_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter1 = new ClassAdapter(ClassData.getListData(), this);

        recyclerView.setAdapter(adapter1);
        adapter1.setItemClickCallback(this);

    }

    @Override
    public void onItemClick(int p) {

        ListItem item = (ListItem) listData.get(p);

        Intent i = new Intent(this, DetailActivity.class);

        Bundle extras = new Bundle();
        extras.putString(bundle1, item.getTitle());
        i.putExtra(bundle, extras);
        startActivity(i);

    }


    @Override
    public void onSecondaryIconClick(int p) {
        ListItem item = (ListItem) listData.get(p);


        if (item.isFavourite()) {
            item.setFavourite(false);
        } else {
            item.setFavourite(true);
        }

        adapter1.setListItemData(listData);
        adapter1.notifyDataSetChanged();
    }

}