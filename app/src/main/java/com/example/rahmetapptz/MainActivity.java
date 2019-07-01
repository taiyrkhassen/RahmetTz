package com.example.rahmetapptz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rahmetapptz.mvp.BranchesView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "View";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, BranchesView.class));

    }
}
