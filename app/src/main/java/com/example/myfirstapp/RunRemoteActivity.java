package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLOutput;

public class RunRemoteActivity extends AppCompatActivity {
    String EXTRA_MESSAGE="com.example.myfirstapp.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_remote);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String remote_name = intent.getStringExtra(EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(remote_name);
    }
}
