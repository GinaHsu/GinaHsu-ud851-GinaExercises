package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    public static final String DATABASE_NAME = "waitlist.db";
    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1
    public static final int DATABASE_VERSION = 1;

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    // TODO (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        final String SQL_CREATE_WAITLIST_TABLE = "Create Table "+
                WaitlistContract.WaitlistEntry.TABLE_NAME +" ( "+
                WaitlistContract.WaitlistEntry._ID+" Integer Primary Key Autoincrement, "+
                WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME+" Text Not Null, "+
                WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE+" Integer Not Null, "+
                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP+" Timestamp Default Current_Timestamp"+
                " ); ";

        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // TODO (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        db.execSQL("Drop Table if exists "+ WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(db);
    }
}