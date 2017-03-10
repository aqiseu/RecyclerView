package com.android.intermed.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.intermed.recyclerview.R;

public class DetailActivity extends AppCompatActivity {
    private static final String bundle = "bundle";
    private static final String bundle1 = "bundle1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getBundleExtra(bundle);

        ((TextView) findViewById(R.id.text)).setText(extras.getString(bundle1));
    }

}