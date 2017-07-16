package com.example.myfirstapp;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.message";
    public static final String EXTRA_ID = "com.example.myfirstapp.remoteid";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = getBaseContext();
        List ids = getRemotes();
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Arrays.toString(ids.toArray()));

        //* *EDIT* *
        ListView listview = (ListView) findViewById(R.id.listView);
//        listview.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, ids));
        listview.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {

        // Then you start a new Activity via Intent
        ListView listview = (ListView) findViewById(R.id.listView);
        String remote_name = (String) listview.getItemAtPosition(position);
            Intent intent = new Intent(this, RunRemoteActivity.class);
            intent.putExtra(EXTRA_MESSAGE, remote_name);
//            intent.putExtra(EXTRA_ID, remote_id);
            startActivity(intent);

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
