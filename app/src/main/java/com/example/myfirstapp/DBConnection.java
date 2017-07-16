package com.example.myfirstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by ASUS on 2017-07-16.
 */

public final class DBConnection extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FirstApp.db";

    private static final String SQL_CREATE_REMOTES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " STRING)";

    private static final String SQL_CREATE_BUTTONS =
            "CREATE TABLE " + FeedEntry.TABLE_NAME2 + " (" +
                    FeedEntry.ID2 + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_BUTTON_NAME + " STRING"+
                    FeedEntry.COLUMN_NAME_REMOTE_ID + " INTEGER"+
                    FeedEntry.COLUMN_NAME_HEX_VAL + " STRING"+
                    FeedEntry.COLUMN_NAME_ENCODER + " STRING"+
                    FeedEntry.COLUMN_NAME_LEN + " STRING"+
                    FeedEntry.COLUMN_NAME_BUTTON_NAME + " STRING"
                    +")";

    private static final String SQL_DELETE_REMOTES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    private static final String SQL_DELETE_BUTTONS =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME2;

    public DBConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_REMOTES);
        db.execSQL(SQL_CREATE_BUTTONS);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_REMOTES);
        db.execSQL(SQL_DELETE_BUTTONS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
