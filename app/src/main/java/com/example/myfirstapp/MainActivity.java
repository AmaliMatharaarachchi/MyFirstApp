package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.remotename";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = getBaseContext();
        List ids = getRemotes();
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Arrays.toString(ids.toArray()));

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, TrainingActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String remote_name = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, remote_name);
        startActivity(intent);
        setRemotes(remote_name);

    }

    public List getRemotes() {
        return (new ReadWriteDB()).read(context);
    }

    public void setRemotes(String remote_name){
        (new ReadWriteDB()).write(context, remote_name);
    }
}
