package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TrainingActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.message";
    public String remote_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        remote_name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(remote_name);


    }
    public void runRemote(View view){
        Intent intent = new Intent(this, RunRemoteActivity.class);
        intent.putExtra(EXTRA_MESSAGE, remote_name);
        startActivity(intent);
    }

    public void trainButton(View view){
        Intent intent = new Intent(this, TrainButtonActivity.class);
        startActivity(intent);
    }

}
