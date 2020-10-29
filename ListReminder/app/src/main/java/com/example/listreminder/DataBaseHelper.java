package com.example.listreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DbName = "Items.db";
    private static final String TableName = "Items";
    private static final String Name = "NAME";
    private static final String Marks = "MARKS";

    public DataBaseHelper(Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }

    public boolean Insert(String name, Integer marks) {
        SQLiteDatabase mDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name, name);
        contentValues.put(Marks, marks);
        return mDB.insert(TableName, null, contentValues) != -1;
    }

    public Cursor getData() {
        SQLiteDatabase mDB = this.getWritableDatabase();
        return mDB.rawQuery("SELECT * FROM " + TableName, null);
    }

    public void Delete() {
        SQLiteDatabase mDB = this.getWritableDatabase();
        mDB.delete(TableName, "1", null);
        mDB.rawQuery("DELETE  FROM " + TableName, null);
        mDB.close();

    }

}
